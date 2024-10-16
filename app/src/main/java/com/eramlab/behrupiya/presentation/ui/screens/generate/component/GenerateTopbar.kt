package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.generateyopbarcomponent.backButton
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.generateyopbarcomponent.categoryFilters
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.generateyopbarcomponent.imageIcon


@Composable
fun GenerateTopbar(
    navController: NavController,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            backButton(
                navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.2f)
            )

            categoryFilters(
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = onCategorySelected,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.7f)
            )
            imageIcon(
                navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.1f)
            )
        }
    }
}
