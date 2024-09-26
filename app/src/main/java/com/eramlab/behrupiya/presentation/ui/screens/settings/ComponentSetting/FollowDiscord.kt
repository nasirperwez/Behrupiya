package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R


@Composable
fun FollowDiscord(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().padding(start = 20.dp , end = 20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ad_img),
            contentDescription = null, modifier = Modifier.fillMaxSize()
        )
    }
}