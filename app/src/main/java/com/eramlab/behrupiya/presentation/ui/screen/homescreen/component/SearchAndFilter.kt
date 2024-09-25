package com.eramlab.behrupiya.presentation.ui.screen.homescreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.data.model.Item

@Composable
fun SearchAndFilter(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    items: List<Item>,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier=modifier.fillMaxSize())
    {
        Column(
            modifier = modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.Blue)

        ) {

            Search(
                modifier = Modifier.weight(.08f)
                    .fillMaxWidth()
            )
            CategoryFilter(
                modifier = Modifier
                    .weight(.08f)
                    .fillMaxWidth(),
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = onCategorySelected
            )
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else {
                ItemGrid(
                    modifier = modifier
                        .weight(.84f)
                        .fillMaxWidth(),
                    items = items
                )
            }

        }
        BottomTaskbar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 0.dp)
        )
    }
}

