package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import androidx.compose.material3.IconButton
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement


@Composable
fun GenerateTopbar(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.10f)
            .background(color = Color(0xC31E1EA7))
    ) {
        Row(
           Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_icn),
                    contentDescription = null
                )
            }

            Row(
               Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sikh ",
                    fontSize = 20.sp,
                    color = Color.White
                )
                GenerateTextSelect()
            }

            IconButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gallery_icn),
                    contentDescription = null
                )
            }
        }
    }
}
