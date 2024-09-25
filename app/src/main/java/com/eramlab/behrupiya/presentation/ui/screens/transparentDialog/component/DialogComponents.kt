package com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun ImagePreviewCard(modifier: Modifier = Modifier, bitmap: Bitmap?) {
    Card(
        modifier = modifier
            .padding(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
    ) {
        bitmap?.let { imageBitmap ->
            Image(
                bitmap = imageBitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, text: String, iconResId: Int, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color.White)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Image(
                modifier = modifier.padding(15.dp),
                painter = painterResource(id = iconResId),
                contentDescription = null
            )
            Text(
                modifier = modifier.padding(5.dp),
                text = text,
                fontSize = 25.sp,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun CloseButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .padding(start = 50.dp, top = 15.dp)
            .size(70.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = null
        )
    }
}

