package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTopbarComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTextSelect

@Composable
fun categoryFilters(modifier: Modifier = Modifier) {

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Sikh ",
            fontSize = 20.sp,
            color = Color.White
        )
        GenerateTextSelect()
    }
}