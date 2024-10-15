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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.utils.NavigationRoutes
import androidx.compose.foundation.clickable


@Composable
fun ImagePreviewCard(
    modifier: Modifier = Modifier,
    bitmap: Bitmap?
) {
    Box(
        modifier = modifier
            .padding(top = 40.dp, end = 50.dp, start = 50.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .shadow(elevation = 15.dp, shape = RoundedCornerShape(15.dp))
            .background(color = Color(0xFF535151))
    ) {
        if (bitmap != null) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        } else {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.default_img),
                    contentDescription = "Default Image"
                )
                Spacer(modifier = Modifier.padding(top = 40.dp))
                Text(text = "No Photo edit yet", color = Color(0xFF807E7E), fontSize = 25.sp)
            }

        }
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    iconResId: Int,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    val blueGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0)) // Two colors for the gradient
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .then(
                if (isSelected) Modifier.background(blueGradient)
                else Modifier.background(Color.White)
            )
            .clickable(onClick = onClick)
            .padding(5.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = modifier.padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                text = text,
                fontSize = 20.sp,
                color = if (isSelected) Color.White else Color(0xFF0050F3)
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

