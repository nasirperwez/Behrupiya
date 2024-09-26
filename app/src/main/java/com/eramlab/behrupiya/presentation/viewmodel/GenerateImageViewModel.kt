package com.eramlab.behrupiya.presentation.viewmodel

import androidx.lifecycle.ViewModel
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

    fun setCategories(categories: List<String>) {
        _categories.value = categories
    }

    fun setSelectedCategory(category: String) {
        _selectedCategory.value = category
    }

    fun setItems(items: List<Item>) {
        _items.value = items
    }

    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
}