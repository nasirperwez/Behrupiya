package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTopbarComponent

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.eramlab.behrupiya.R

import androidx.compose.foundation.Image

@Composable
fun imageIcon(modifier: Modifier) {
    IconButton(
        onClick = { },
        modifier = modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.gallery_icn),
            contentDescription = null
        )
    }
}