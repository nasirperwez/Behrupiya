package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // Import necessary for layout
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryFilter(
    modifier: Modifier = Modifier,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 1.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            val backgroundBrush = if (category == selectedCategory) {
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0  ))
                )
            } else {
                null
            }
            FilterChip(
                selected = category == selectedCategory,
                onClick = { onCategorySelected(category) },
                label = { Text(category) },
                modifier = Modifier
                    .height(48.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .then(
                        if (backgroundBrush != null) Modifier.background(backgroundBrush) else Modifier
                    ),
                shape = RoundedCornerShape(30.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color.Transparent, // Background handled by gradient
                    selectedLabelColor = Color.White,
                    labelColor = Color.White
                )
            )
        }
    }
}