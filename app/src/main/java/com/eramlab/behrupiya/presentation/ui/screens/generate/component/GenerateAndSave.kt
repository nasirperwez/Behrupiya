package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel

@Composable
fun GenerateAndSave(
    navController: NavController,
    generateImageViewModel: GenerateImageViewModel,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 30.dp,
                    bottomEnd = 30.dp
                )
            )
            .background(color = Color(0xFF333333)),
//

    ) {


        GenerateTopbar(
            navController,
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = onCategorySelected,
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
        Spacer(modifier = Modifier.padding(top = 30.dp))
        GenerateAndsave(
            sharedViewModel,
            generateImageViewModel,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)
        )
    }
}