package com.eramlab.behrupiya.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.data.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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

    fun setCategories(categories: List<String>) {
        _categories.value = categories
    }

    fun setSelectedCategory(category: String) {
//        _selectedCategory.value = category

        _selectedCategory.value = category
        _items.value = when (category) {
            "All" -> _categoryData.value.flatMap { it.items }
            else -> _categoryData.value.find { it.category == category }?.items ?: emptyList()
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
}