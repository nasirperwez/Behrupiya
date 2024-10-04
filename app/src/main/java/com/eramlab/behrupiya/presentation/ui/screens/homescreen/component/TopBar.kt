package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    val blueGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0)) // Two colors for the gradient
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.header_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
        )
        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .size(width = 100.dp, height = 33.dp)
                .background(blueGradient, shape = RoundedCornerShape(30.dp))
        ) {
            Text("Get Pro", fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
    }
}