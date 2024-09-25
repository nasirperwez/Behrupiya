package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SaveNow(modifier: Modifier) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = RoundedCornerShape(30.dp),
        modifier = modifier
            //.align(Alignment.CenterHorizontally)
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
    ) {
        Text(text = "Save Now", fontSize = 15.sp, color = Color.White)
    }
}