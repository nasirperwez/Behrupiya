package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R

@Composable
fun TopBarSetting(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center // This centers the content inside the Box
    ) {
        Image(
            painter = painterResource(id = R.drawable.header_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
        )
    }
}