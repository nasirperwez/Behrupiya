package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun SelectedImage(modifier: Modifier, sharedViewModel: SharedViewModel) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.50f)
            //.padding(30.dp)
            .clip(
                RoundedCornerShape(
                    30.dp
                )
            )
            .background(color = Color(0xF29B87C0))
    ) {
        val bitmap by sharedViewModel.bitmap
        bitmap?.let { btm ->
            Image(
                bitmap = btm.asImageBitmap(),
                contentDescription = "Passed Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

//        Image(
//            painter = painterResource(id = R.drawable.aa),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxSize()
//                .align(Alignment.Center)
//        )
    }
}
