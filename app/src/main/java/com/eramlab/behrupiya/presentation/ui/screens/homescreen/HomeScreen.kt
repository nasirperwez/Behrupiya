package com.eramlab.behrupiya.presentation.ui.screens.homescreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
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
//    Image(
//        painter = painterResource(id = R.drawable.behrupiya_dashboard_1),
//        contentDescription = "Logo",
//        modifier = Modifier
//            .fillMaxSize()
//            .graphicsLayer(alpha = 0.30f)
//    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
    ) {

        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.1f)
                .padding(top = 10.dp, start = 20.dp, end = 20.dp)
        )
        FeaturedContent(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.3f)
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
                .weight(.6f)
                .padding(top = 10.dp)
        )
    }
}



