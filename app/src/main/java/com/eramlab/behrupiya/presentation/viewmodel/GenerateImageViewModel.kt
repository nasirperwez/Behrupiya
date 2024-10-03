package com.eramlab.behrupiya.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.Item
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.eramlab.behrupiya.utils.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class GenerateImageViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Store the entire CategoryData list
    private val _categoryData = MutableStateFlow<List<CategoryData>>(emptyList())

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState

    fun setCategories(categories: List<String>) {
        _categories.value = categories
    }

    fun setSelectedCategory(category: String) {
//        _selectedCategory.value = category

        _selectedCategory.value = category
        _items.value = when (category) {
            "All" -> _categoryData.value.flatMap { it.effects }
            else -> _categoryData.value.find { it.name == category }?.effects ?: emptyList()
        }
    }

    fun setCategoryData(categoryData:List<CategoryData>)
    {
        _categoryData.value = categoryData
    }


    fun setItems(items: List<Item>) {
        _items.value = items
    }

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
    private val client = HttpClient(Android)

    fun OngenerateImage(bitmap: Bitmap, prompt: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading
            try {
                val file = createTempFileFromBitmap(bitmap)
                val response = client.submitFormWithBinaryData(
                    url = "http://192.168.1.3:8080/generate-image/",
                    formData = formData {
                        append("files", file.readBytes(), Headers.build {
                            append(HttpHeaders.ContentType, "image/jpeg")
                            append(HttpHeaders.ContentDisposition, "filename=\"image.jpg\"")
                        })
                        append("prompt", prompt)
                        append("negative_prompt", "")
                        append("style", "Photographic (Default)")
                        append("steps", "50")
                        append("width", "1024")
                        append("height", "1024")
                    }
                ) {
                    method = HttpMethod.Post
                }
                if (response.status.isSuccess()) {
                    val responseBody = response.bodyAsText()
                    val jsonObject = Json.decodeFromString<Map<String, String>>(responseBody)
                    val imageUrl = jsonObject["image_url"]

                    if (imageUrl != null) {
                        _uiState.value = UiState.Success(imageUrl)
                    } else {
                        _uiState.value = UiState.Error("No image URL in response")
                    }
                } else {
                    _uiState.value = UiState.Error("Server responded with ${response.status}")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown error occurred")
            }
        }
    }


}


sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    data class Success(val message: String) : UiState()
    data class Error(val message: String) : UiState()
}

fun createTempFileFromBitmap(bitmap: Bitmap): File {
    val file = File.createTempFile("temp_image", ".jpg")
    val bos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bos)
    val bitmapData = bos.toByteArray()
    val fos = FileOutputStream(file)
    fos.write(bitmapData)
    fos.flush()
    fos.close()
    return file
}