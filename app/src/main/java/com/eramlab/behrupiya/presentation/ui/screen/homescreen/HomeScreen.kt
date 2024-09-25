package com.eramlab.behrupiya.presentation.ui.screen.homescreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel
import com.eramlab.behrupiya.presentation.ui.screen.homescreen.component.FeaturedContent
import com.eramlab.behrupiya.presentation.ui.screen.homescreen.component.SearchAndFilter
import com.eramlab.behrupiya.presentation.ui.screen.homescreen.component.TopBar

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val categories by viewModel.categories.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val items by viewModel.items.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xC3202027))
    ) {
        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.08f)
        )
        FeaturedContent(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.25f)
        )
        SearchAndFilter(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { viewModel.selectCategory(it) },
            items = items,
            isLoading = isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.67f)
        )
    }
}



