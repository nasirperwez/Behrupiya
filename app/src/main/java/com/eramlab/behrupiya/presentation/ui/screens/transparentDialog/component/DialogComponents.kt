package com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.component

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.room.util.copy
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.utils.NavigationRoutes

@Composable
fun ImagePreviewCard(
    modifier: Modifier = Modifier,
    bitmap: Bitmap?
) {

    Card(
        modifier = modifier
            .padding(50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .shadow(elevation = 0.dp, shape = RoundedCornerShape(15.dp))
    ) {
        if (bitmap != null) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.aa),
                contentDescription = "Default Image",
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
fun CloseButton(navController: NavController, onClick: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = {
            navController.navigate(
                NavigationRoutes.HOME
            )
        },
        modifier = modifier
            .padding(start = 50.dp, top = 15.dp)
            .size(70.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.close),
            contentDescription = null
        )
    }
}

