package com.eramlab.behrupiya.data.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.GenerateImageResponse
import com.eramlab.behrupiya.data.model.Prompt
import com.eramlab.behrupiya.data.model.RegisterResponse
import com.eramlab.behrupiya.presentation.viewmodel.UiState
import com.eramlab.behrupiya.presentation.viewmodel.createTempFileFromBitmap
import com.eramlab.behrupiya.utils.AppConstants
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.InternalAPI
import io.ktor.util.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File
import java.security.MessageDigest
import java.util.Random
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class NetworkLayer {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
//    private val BASE_URL = "http://127.0.0.1:8090"
    private val SHARED_SECRET_KEY = AppConstants.SHARED_SECRET_KEY

    private val json = Json { ignoreUnknownKeys = true }

    suspend fun fetchCategoryData(): List<CategoryData> {
        return client.get(AppConstants.JSON_DATA_ENDPOINT).body()
    }

    @OptIn(InternalAPI::class)
    suspend fun generateimage(bitmap: Bitmap, prompt: String , imageFile:File ): HttpResponse {


             return client.post("http://192.168.1.3:8080/generate-image/") {
                    headers {
                        append(HttpHeaders.Accept, "application/json")
                    }
                    body = MultiPartFormDataContent(
                        formData {
                            append("files", imageFile.readBytes(), Headers.build {
                                append(HttpHeaders.ContentType, "image/jpeg")
                                append(HttpHeaders.ContentDisposition, "filename=\"${imageFile.name}\"")
                            })
                            append("prompt", prompt)
                            append("negative_prompt", "Blurry, low quality, distorted faces, extra limbs, unnatural lighting, oversaturated colors, pixelation, artifacts, unrealistic proportions, text, logos, watermark, grainy textures, messy backgrounds, chaotic composition, noise, harsh shadows, inconsistent details, overly smooth skin, exaggerated facial expressions, odd angles, missing details, incorrect anatomy, overexposure, underexposure, warped edges.")
                            append("style", "Photographic (Default)")
                            append("steps", "50")
                            append("width", "1024")
                            append("height", "1024")
                        }
                    )
                }




    }

    suspend fun loadBitmapFromUrl(imageUrl: String): Bitmap? = withContext(Dispatchers.IO) {
        try {
            val client = HttpClient(Android)
            val response: HttpResponse = client.get(imageUrl)
            val inputStream = response.bodyAsChannel().toByteArray().inputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            client.close()
            bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    fun close() {
        client.close()
    }



    private fun encryptData(plainText: String, sharedKey: ByteArray): String {
        val key = MessageDigest.getInstance("SHA-256").digest(sharedKey)
        val iv = ByteArray(16).apply { Random().nextBytes(this) }

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))

        val encryptedBytes = cipher.doFinal(plainText.toByteArray())
        return Base64.encodeToString(iv + encryptedBytes, Base64.DEFAULT)
    }

    private fun generateEncryptedData(): String {
        val timestamp = System.currentTimeMillis().toString()
        val keybyte = SHARED_SECRET_KEY.toByteArray()
        return encryptData(timestamp, keybyte)
    }

    suspend fun registerUser(deviceId: String): String? {
        val response: HttpResponse = client.post("${AppConstants.BASE_URL}/silent-registration") {
            contentType(ContentType.Application.FormUrlEncoded)
            setBody(FormDataContent(Parameters.build {
                append("device_id", deviceId)
                append("encrypted_data", generateEncryptedData())
            }))
        }
        val responseBody: String = response.bodyAsText()
        return try {
            val registerResponse: RegisterResponse = json.decodeFromString(responseBody)
            registerResponse.data.apiKey
        } catch (e: Exception) {
            println("Error parsing response: ${e.message}")
            null
        }
    }

    suspend fun generateImage(apiKey: String, imagePath: String, prompt: String, negativePrompt: String, style: String): String? {
        val response: HttpResponse = client.post("${AppConstants.BASE_URL}/generate-image/") {
            setBody(MultiPartFormDataContent(formData {
                append("api_key", apiKey)
                append("prompt", prompt)
                append("negative_prompt", negativePrompt)
                append("style", style)
                append("encrypted_data", generateEncryptedData())
                append("image", File(imagePath).readBytes(), Headers.build {
                    append(HttpHeaders.ContentDisposition, "filename=\"image.jpg\"")
                })
            }))
        }

        val responseBody: String = response.bodyAsText()
        return try {
            val generateImageResponse: GenerateImageResponse = json.decodeFromString(responseBody)
            generateImageResponse.imageUrl
        } catch (e: Exception) {
            println("Error parsing response: ${e.message}")
            null
        }
    }


    suspend fun getPrompts(apiKey: String): List<Prompt> {
        val response: HttpResponse = client.get("${AppConstants.BASE_URL}/prompts") {
            parameter("api_key", apiKey)
            parameter("encrypted_data", generateEncryptedData())
        }
        val responseBody: String = response.bodyAsText()
        return try {
            json.decodeFromString<List<Prompt>>(responseBody)
        } catch (e: Exception) {
            println("Error parsing response: ${e.message}")
            emptyList()
        }
    }
}