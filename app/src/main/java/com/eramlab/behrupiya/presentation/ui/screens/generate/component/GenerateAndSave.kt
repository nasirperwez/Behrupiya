package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun GenerateAndSave(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(color = Color(0xC3202027)),
//        verticalArrangement = Arrangement.SpaceBetween

    ) {


        GenerateTopbar(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = {  },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        )

        GenerateImage(
            sharedViewModel,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.65f),

        )

        GenerateAndsave(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)
        )

    }


}