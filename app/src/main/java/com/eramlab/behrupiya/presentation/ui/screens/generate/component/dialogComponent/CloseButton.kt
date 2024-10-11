package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R

@Composable
fun CloseButton(
    modifier: Modifier,
    onClose: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.close_icn),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp, top = 5.dp)
                .size(20.dp)
                .align(Alignment.TopEnd)
                .clickable { onClose() }
        )
    }
}