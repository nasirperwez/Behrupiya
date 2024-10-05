package com.eramlab.behrupiya.data.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.presentation.viewmodel.UiState
import com.eramlab.behrupiya.presentation.viewmodel.createTempFileFromBitmap
import com.eramlab.behrupiya.utils.AppConstants
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.InternalAPI
import io.ktor.util.toByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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


}