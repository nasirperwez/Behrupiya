package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R

@Composable
fun GenerateImage(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth().fillMaxHeight().background(color = Color.Yellow),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth(0.75f)


        ) {


            Card(

                modifier = Modifier
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(15.dp)),


                ) {
                Image(
                    painter = painterResource(id = R.drawable.aa),
                    contentDescription = null, modifier = Modifier.fillMaxSize()


                )


            }
        }
    }
}