package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PhoteoAndVideo(modifier: Modifier) {
    var selectedBox by remember { mutableStateOf<String?>(null) }
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f) // Use weight to take up half the width
                .background(
                    if (selectedBox == "video") Color.Transparent else Color(
                        0xEB363434
                    )
                )
                .clickable { selectedBox = "video" },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Video",
                color = if (selectedBox == "video") Color.Blue else Color(0xEBB5AEC9)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f) // Use weight to take up the remaining half
                .background(
                    if (selectedBox == "photo") Color.Transparent else Color(
                        0xEB363434
                    )
                )
                .clickable { selectedBox = "photo" },
            contentAlignment = Alignment.Center // Center the text
        ) {
            Text(
                text = "Photo",
                color = if (selectedBox == "photo") Color.Blue else Color(0xEBB5AEC9)
            )
        }


    }
}