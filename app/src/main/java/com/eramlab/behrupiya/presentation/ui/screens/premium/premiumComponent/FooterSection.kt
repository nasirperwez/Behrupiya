package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FooterSection(modifier: Modifier=Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "WEEKLY ACCESS", color = Color.White, fontSize = 20.sp)
        Text(text = "just ₹ 199.00 per week", color = Color(0xFF77B4D8), fontSize = 15.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF77B4D8)),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Continue")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Recurring | Cancel anytime", color = Color(0xFF8A9196), fontSize = 15.sp)
    }
}