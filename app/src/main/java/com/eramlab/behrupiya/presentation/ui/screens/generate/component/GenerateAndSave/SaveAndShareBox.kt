package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent.SaveAndShare

@Composable
fun SaveAndShareBox(sharedViewModel: SharedViewModel) {
    var showDialog by remember { mutableStateOf(false) }
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
            .clickable { showDialog = true }

    ) {
        Text(
            stringResource(id = R.string.SaveShareButton),
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = 15.sp
        )
    }
    if (showDialog) {
        SaveAndShare(onDismiss = { showDialog = false }, sharedViewModel = sharedViewModel)
    }
}