package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SaveNow(modifier: Modifier) {
    val blueGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0)) // Two colors for the gradient
    )
    Box(
        contentAlignment = Alignment.Center, // Center the button within the Box
        modifier = modifier
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .width(250.dp)
                .background(blueGradient, shape = RoundedCornerShape(30.dp))
        ) {
            Text(text = "Save Now", fontSize = 15.sp, color = Color.White)
        }
    }
}