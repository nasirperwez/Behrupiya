package com.eramlab.behrupiya.presentation.viewmodel


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.data.model.PromptsResponse
import com.eramlab.behrupiya.data.network.NetworkLayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class HomeViewModel : ViewModel() {
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
    val categoryData: StateFlow<List<CategoryData>> = _categoryData

    private val networkLayer = NetworkLayer()

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchData() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = networkLayer.getPrompt()
                _categoryData.value = response.data.prompts.categories
                _categories.value = response.data.prompts.categories.map { it.name }.plus("All")

                _items.value = response.data.prompts.categories.flatMap { it.effects }
                val name =response.data.prompts.categories[0].name
                println( name)



            } catch (e: Exception) {
                // Handle error
                println("Error fetching data: ${e.message}")
            } finally {

            }
        }
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
        _items.value = when (category) {
            "All" -> _categoryData.value.flatMap { it.effects }
            else -> _categoryData.value.find { it.name == category }?.effects ?: emptyList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        networkLayer.close()
    }
}


