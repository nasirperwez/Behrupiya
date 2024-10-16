package com.eramlab.behrupiya.data.network

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import com.eramlab.behrupiya.data.model.ApiResponse
import com.eramlab.behrupiya.data.model.ImageResponse
import com.eramlab.behrupiya.data.model.PromptsResponse
import com.eramlab.behrupiya.utils.AppConstants
import com.eramlab.behrupiya.utils.KeyStoreManager
import com.eramlab.behrupiya.utils.encryptData
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
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getFooter(): PromptsResponse {
        return  client.get("${AppConstants.BASE_URL_SERVER}/footers") {
            parameter("encrypted_data", generateEncryptedData())
        }.body()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getHeader(): PromptsResponse {
        return  client.get("${AppConstants.BASE_URL_SERVER}/headers") {
            parameter("encrypted_data", generateEncryptedData())
        }.body()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun generateImagesev(apiKey: String,prompt: String, imagePath: File): ImageResponse {
        return client.post("${AppConstants.BASE_URL_SERVER}/generate-image/") {
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
        }.body()
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


    @RequiresApi(Build.VERSION_CODES.O)
    private fun generateEncryptedData(): String {
        val timestamp = (System.currentTimeMillis()/ 1000).toString()
         println(timestamp)
        return encryptData(timestamp , AppConstants.SHARED)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun registerUser(context: Context,deviceId: String): String? {
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

    // PKCS7 padding implementation
    fun ByteArray.pad(): ByteArray {
        val blockSize = 16
        val padding = blockSize - (this.size % blockSize)
        return this + ByteArray(padding) { padding.toByte() }
    }

}