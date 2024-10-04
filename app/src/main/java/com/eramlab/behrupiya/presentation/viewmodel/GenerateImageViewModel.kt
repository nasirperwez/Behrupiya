package com.eramlab.behrupiya.presentation.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.data.network.NetworkLayer
import com.eramlab.behrupiya.presentation.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream



class GenerateImageViewModel() : ViewModel() {

    private lateinit var sharedViewModel: SharedViewModel
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

    private val networkLayer = NetworkLayer()

    fun setCategories(categories: List<String>) {
        _categories.value = categories
    }

    fun setSelectedCategory(category: String) {
        _selectedCategory.value = category
        _items.value = when (category) {
            "All" -> _categoryData.value.flatMap { it.effects }
            else -> _categoryData.value.find { it.name == category }?.effects ?: emptyList()
        }
    }

    fun setSharedViewModel(viewModel: SharedViewModel) {
        sharedViewModel = viewModel
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
      fun onGenerateImage(bitmap: Bitmap, prompt: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading
            try {
                val imageFile = createTempFileFromBitmap(bitmap)

                val response: HttpResponse = networkLayer.generateimage(bitmap, prompt, imageFile)

           // Delete the temporary file after it's been sent
                imageFile.delete()

                if (response.status.isSuccess()) {
                    val responseBody = response.bodyAsText()
                    val jsonObject = Json.decodeFromString<Map<String, String>>(responseBody)
                    val imageUrl = jsonObject["image_url"]

                    if (imageUrl != null) {
                            _uiState.value = UiState.Success(imageUrl)
                            val generatedbitmap = networkLayer.loadBitmapFromUrl(imageUrl)
                            if (generatedbitmap != null) {
                                sharedViewModel.setBitmap(generatedbitmap)
                            }

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