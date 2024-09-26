package com.eramlab.behrupiya.presentation.ui.screens.homescreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.FeaturedContent
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.SearchAndFilter
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.TopBar

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    homeViewModel: HomeViewModel) {

    val categories by homeViewModel.categories.collectAsState()
    val selectedCategory by homeViewModel.selectedCategory.collectAsState()
    val items by homeViewModel.items.collectAsState()
    val isLoading by homeViewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        homeViewModel.fetchData()
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
            sharedViewModel,
            navController,
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { homeViewModel.selectCategory(it) },
            items = items,
            isLoading = isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.67f)
        )
    }
}



