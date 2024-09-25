package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun GenerateButton() {
    Row {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        30.dp
                    )
                )
                .background(color = Color(0xFF77B4D8))
                .height(50.dp)
                .fillMaxWidth(0.70f)
                .clickable { }

        )
        {
            Text(
                text = "Generate",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 15.sp
            )
        }
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        30.dp
                    )
                )
                .background(color = Color.Transparent)
                .height(50.dp)
                .fillMaxWidth()
                .clickable { }

        ) {
            Image(
                painter = painterResource(id = R.drawable.add_img),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
        }


    }
}
