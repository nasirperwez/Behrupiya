package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GenerateAndSave(modifier: Modifier = Modifier) {
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
        GenerateTopbar()
        Spacer(modifier = Modifier.height(16.dp))
        GenerateImage()
       Spacer(modifier = Modifier.height(20.dp))
        GenerateAndsave()

    }


}