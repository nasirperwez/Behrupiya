package com.eramlab.behrupiya.presentation.ui.screens.generate

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateCard
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel


@Composable
fun GenerateImageScreen(
    generateImageViewModel: GenerateImageViewModel,
    sharedViewModel: SharedViewModel,
    navController: NavController ) {


    val categories by generateImageViewModel.categories.collectAsState()
    val selectedCategory by generateImageViewModel.selectedCategory.collectAsState()
    val items by generateImageViewModel.items.collectAsState()
   // val isLoading by generateImageViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xC3202027))
    )
    {
        GenerateAndSave(
            navController,
            generateImageViewModel,
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = {  generateImageViewModel.setSelectedCategory(it)},
            sharedViewModel,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.75f),

        )
        GenerateCard(
            items = items,
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = {  },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)


        )

    }
}

