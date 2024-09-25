package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
@Composable
fun GenerateBox() {
    Box(
        Modifier
            .clip(
                RoundedCornerShape(
                    30.dp
                )
            )
            .background(color = Color(0xC3202027))
            .height(50.dp)
            .fillMaxWidth(0.75f)

    ) {
        SaveButton()
    }
}