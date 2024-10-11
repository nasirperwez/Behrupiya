package com.eramlab.behrupiya.data.network

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.provider.Settings

import androidx.annotation.RequiresApi
import com.eramlab.behrupiya.data.model.ApiResponse
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.GenerateImageResponse
import com.eramlab.behrupiya.data.model.Prompt
import com.eramlab.behrupiya.data.model.PromptsResponse
import com.eramlab.behrupiya.utils.AppConstants
import com.eramlab.behrupiya.utils.KeyStoreManager
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
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.InternalAPI
import io.ktor.util.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.Base64
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
    private val SHARED_SECRET_KEY = AppConstants.SHARED

    private val json = Json { ignoreUnknownKeys = true }

    suspend fun fetchCategoryData(): List<CategoryData> {
        return client.get(AppConstants.JSON_DATA_ENDPOINT).body()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getPrompt(): PromptsResponse {
        return  client.get("${AppConstants.BASE_URL_SERVER}/prompts") {
            parameter("encrypted_data", generateEncryptedData())
        }.body()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun generateImagesev(apiKey: String,prompt: String, imagePath: File): String? {


        println("Nasir = " +  apiKey)

        val response: HttpResponse = client.post("${AppConstants.BASE_URL_SERVER}/generate-image/") {
            setBody(MultiPartFormDataContent(formData {
                append("api_key", apiKey)
                append("prompt", prompt)
                append("negative_prompt", "")
                append("style", "Photographic")
                append("encrypted_data", generateEncryptedData())
                append("image", imagePath.readBytes(), Headers.build {
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

    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(InternalAPI::class)
    suspend fun generateimage(apiKey: String,prompt: String , imageFile:File ): HttpResponse {


        return client.post("${AppConstants.BASE_URL_SERVER}/generate-image/") {
            headers {
                append(HttpHeaders.Accept, "application/json")
            }
            body = MultiPartFormDataContent(
                formData {
                    append("image", imageFile.readBytes(), Headers.build {
                        append(HttpHeaders.ContentType, "image/jpeg")
                        append(HttpHeaders.ContentDisposition, "filename=\"${imageFile.name}\"")
                    })
                    append("api_key", apiKey)
                    append("prompt", prompt)
                    append("negative_prompt", "Blurry, low quality, distorted faces, extra limbs, unnatural lighting, oversaturated colors, pixelation, artifacts, unrealistic proportions, text, logos, watermark, grainy textures, messy backgrounds, chaotic composition, noise, harsh shadows, inconsistent details, overly smooth skin, exaggerated facial expressions, odd angles, missing details, incorrect anatomy, overexposure, underexposure, warped edges.")
                    append("style", "Photographic (Default)")
                    append("encrypted_data", generateEncryptedData())

                }
            )
        }
    }


//    @OptIn(InternalAPI::class)
//    suspend fun generateimage(prompt: String , imageFile:File ): HttpResponse {
//
//
//             return client.post(AppConstants.GENERATE_IMAGE_ENDPOINT) {
//                    headers {
//                        append(HttpHeaders.Accept, "application/json")
//                    }
//                    body = MultiPartFormDataContent(
//                        formData {
//                            append("files", imageFile.readBytes(), Headers.build {
//                                append(HttpHeaders.ContentType, "image/jpeg")
//                                append(HttpHeaders.ContentDisposition, "filename=\"${imageFile.name}\"")
//                            })
//                            append("prompt", prompt)
//                            append("negative_prompt", "Blurry, low quality, distorted faces, extra limbs, unnatural lighting, oversaturated colors, pixelation, artifacts, unrealistic proportions, text, logos, watermark, grainy textures, messy backgrounds, chaotic composition, noise, harsh shadows, inconsistent details, overly smooth skin, exaggerated facial expressions, odd angles, missing details, incorrect anatomy, overexposure, underexposure, warped edges.")
//                            append("style", "Photographic (Default)")
//                            append("steps", "50")
//                            append("width", "1024")
//                            append("height", "1024")
//                        }
//                    )
//                }
//
//
//
//
//    }

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






       @RequiresApi(Build.VERSION_CODES.O)
       fun encryptData(plainText: String, sharedKey: String): String {
           // Create SHA-256 hash of the shared key
           val key = MessageDigest.getInstance("SHA-256").digest(sharedKey.toByteArray())

           // Generate a random IV
           val iv = ByteArray(16)
           SecureRandom().nextBytes(iv)

           // Initialize the cipher for AES in CBC mode with PKCS5 padding
           val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
           val secretKey = SecretKeySpec(key, "AES")
           val ivSpec = IvParameterSpec(iv)
           cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec)

           // Encrypt the plaintext
           val encryptedData = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))

           // Combine IV and ciphertext
           val combinedData = iv + encryptedData
            val test = Base64.getEncoder().encodeToString(combinedData)
           println(test)
           // Encode the combined data as Base64 without line breaks
           return Base64.getEncoder().encodeToString(combinedData)
       }





    @RequiresApi(Build.VERSION_CODES.O)
    private fun generateEncryptedData(): String {
        val timestamp = (System.currentTimeMillis()/ 1000).toString()
         println(timestamp)
        return encryptData(timestamp , SHARED_SECRET_KEY)
    }

    @SuppressLint("HardwareIds")
    fun getDeviceId(context: Context): String {
        println(Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID))
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun registerUser(context: Context,deviceId: String): String? {
//        getDeviceId(context = )
        val response: HttpResponse = client.post("${AppConstants.BASE_URL_SERVER}/silent-registration") {
            contentType(ContentType.Application.FormUrlEncoded)
            setBody(FormDataContent(Parameters.build {
                append("device_id", deviceId)
                append("encrypted_data",generateEncryptedData() )
            }))
        }
        val responseBody: String = response.bodyAsText()
        return try {
            val apiResponse: ApiResponse = Json.decodeFromString(responseBody)
            if (apiResponse.success) {
                apiResponse.data?.apiKey?.let { apiKey ->
                    // Store the API key in KeyStore
                    KeyStoreManager(context).storeApiKey(apiKey)
                    apiKey
                }
            } else {
                println("Registration failed: ${apiResponse.message}")
                null
            }
        } catch (e: Exception) {
            println("Error parsing response: ${e.message}")
            null
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun generateImageserver(apiKey: String, imagePath: String, prompt: String, negativePrompt: String, style: String): String? {
        val response: HttpResponse = client.post("${AppConstants.BASE_URL_SERVER}/generate-image/") {
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







    // PKCS7 padding implementation
    fun ByteArray.pad(): ByteArray {
        val blockSize = 16
        val padding = blockSize - (this.size % blockSize)
        return this + ByteArray(padding) { padding.toByte() }
    }

}