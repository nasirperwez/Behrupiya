package com.eramlab.behrupiya.presentation.ui.screen.homescreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun FeaturedContent(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 30.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(4) { index ->
            FeaturedCard(
                imageRes = when (index) {
                    0 -> R.drawable.aa
                    1 -> R.drawable.bb
                    2 -> R.drawable.aa
                    else -> R.drawable.dd
                },modifier
            )
        }
    }
}

@Composable
fun FeaturedCard(imageRes: Int , modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            Text(
                text = "AI art Generator",
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}