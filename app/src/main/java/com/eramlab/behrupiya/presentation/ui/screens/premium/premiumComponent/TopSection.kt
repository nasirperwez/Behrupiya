package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun TopSection(modifier: Modifier=Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 45.dp, start = 25.dp),
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(onClick = { /* Close action */ }) {
            Image(painter = painterResource(id = R.drawable.close_icn), contentDescription = null)
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(text = "Upgrade", fontSize = 35.sp, color = Color(0xFFB5BCC2))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "to", fontSize = 35.sp, color = Color(0xFFB5BCC2))
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Premium",
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}