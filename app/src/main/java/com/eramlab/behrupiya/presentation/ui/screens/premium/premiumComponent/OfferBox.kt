package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun OfferBox(
    selected: Boolean,
    price: String,
    period: String,
    yearAccess: String,
    fullPrice: String,
    year: String,
    isFirstBox: Boolean = false,
    isSecondBox: Boolean = false,
    onClick: () -> Unit,

    ) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Transparent)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(
                id = when {
                    isFirstBox && selected -> R.drawable.button_s_with_tag
                    isSecondBox && selected -> R.drawable.button_s
                    else -> R.drawable.button1
                }
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        if (isFirstBox && selected) {
            Text(
                text = "Best Offer", // Your custom text
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = price, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = period, color = Color.White)
            Spacer(modifier = Modifier.height(18.dp))
            Text(text = yearAccess, color = Color(0xFF77B4D8), fontSize = 15.sp)
            Text(text = fullPrice, color = Color.White)
            Text(text = year, color = Color.White)


        }
    }
}
