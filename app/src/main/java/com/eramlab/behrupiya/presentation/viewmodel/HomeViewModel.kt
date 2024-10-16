package com.eramlab.behrupiya.presentation.viewmodel


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eramlab.behrupiya.data.model.CategoryData

import com.eramlab.behrupiya.data.model.Item

import com.eramlab.behrupiya.data.network.NetworkLayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    //data container For footer
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    // Store the entire CategoryData list
    private val _categoryData = MutableStateFlow<List<CategoryData>>(emptyList())
    val categoryData: StateFlow<List<CategoryData>> = _categoryData

    //data container For Header

    private val _categoriesHeader = MutableStateFlow<List<String>>(emptyList())
    val categoriesHeader: StateFlow<List<String>> = _categoriesHeader

    private val _selectedCategoryHeader = MutableStateFlow("All")
    val selectedCategoryHeader: StateFlow<String> = _selectedCategoryHeader

    private val _itemsHeader = MutableStateFlow<List<Item>>(emptyList())
    val itemsHeader: StateFlow<List<Item>> = _itemsHeader

    // Store the entire CategoryData list
    private val _categoryDataHeader = MutableStateFlow<List<CategoryData>>(emptyList())
    val categoryDataHeader: StateFlow<List<CategoryData>> = _categoryDataHeader




    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading



    private val networkLayer = NetworkLayer()


    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchHeaderData() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = networkLayer.getHeader()
                println("Nasir" + response.toString())
                _categoryDataHeader.value = response.data.prompts.categories
                _categoriesHeader.value = response.data.prompts.categories.map { it.name }.plus("All")

                _itemsHeader.value = response.data.prompts.categories.flatMap { it.effects }
                val name =response.data.prompts.categories[0].name
                println( name)



            } catch (e: Exception) {
                // Handle error
                println("Error fetching data: ${e.message}")
            } finally {

            }
        }
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchFooterData() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = networkLayer.getFooter()
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

    fun selectCategoryHeader(category: String) {
        _selectedCategoryHeader.value = category
        _itemsHeader.value = when (category) {
            "All" -> _categoryDataHeader.value.flatMap { it.effects }
            else -> _categoryDataHeader.value.find { it.name == category }?.effects ?: emptyList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        networkLayer.close()
    }
}


