package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TaskbarIcon(
    iconResId: Int,
    onClick: () -> Unit,
    size: Dp = 24.dp,
    paddingStart: Dp = 20.dp
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 10.dp, start = paddingStart)
            .size(size)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null
        )
    }
}