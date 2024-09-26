package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun TryButton(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Text(
            text = "Try out the trial for 3 days",
            modifier = Modifier.clickable { },
            fontSize = 15.sp,
            style = androidx.compose.ui.text.TextStyle(
                textDecoration = TextDecoration.Underline
            ),
            color = Color.White

        )
    }
}