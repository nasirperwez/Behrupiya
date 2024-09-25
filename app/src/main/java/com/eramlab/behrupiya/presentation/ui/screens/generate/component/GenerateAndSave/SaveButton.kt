package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip

import com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent.SaveAndSheare


@Composable
fun SaveButton() {
    var showDialog by remember { mutableStateOf(false) }
    Box(modifier = Modifier

        .clip(
            RoundedCornerShape(
                30.dp
            )
        )
        .background(color = Color(0xC3202027))
        .height(50.dp)
        .fillMaxWidth()
        .clickable { showDialog = true }
        //.align(Alignment.CenterHorizontally)
    ) {
        Text(
            text = "Save / Share",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = 15.sp
        )
    }
    if (showDialog) {
        SaveAndSheare(onDismiss = { showDialog = false })
    }

}


