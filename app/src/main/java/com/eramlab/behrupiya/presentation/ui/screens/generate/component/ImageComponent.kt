package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
fun GenerateAndsave(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth().fillMaxHeight()
            .background(color = Color.Green)
    ) {
        Box(
            Modifier
                .clip(
                    RoundedCornerShape(
                        30.dp
                    )
                )
                .background(color = Color(0xC3202027))
                .height(50.dp)
                .fillMaxWidth(0.75f)
                .align(Alignment.CenterHorizontally)

        ) {
            Row {
//                Box(
//                    modifier = Modifier
//                        .clip(
//                            RoundedCornerShape(
//                                30.dp
//                            )
//                        )
//                        .background(color = Color(0xFF77B4D8))
//                        .height(50.dp)
//                        .fillMaxWidth(0.70f)
//                        .clickable { }
//
//                )
//                {
//                    Text(
//                        text = "Generate",
//                        modifier = Modifier.align(Alignment.Center),
//                        color = Color.White,
//                        fontSize = 15.sp
//                    )
//                }
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
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier

                .clip(
                    RoundedCornerShape(
                        30.dp
                    )
                )
                .background(color = Color(0xC3202027))
                .height(50.dp)
                .fillMaxWidth(0.75f)
                .clickable { }
                .align(Alignment.CenterHorizontally)
        )
        {
            Text(
                text = "Save / Share",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 15.sp
            )
        }


    }
}