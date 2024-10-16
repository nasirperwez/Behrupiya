package com.eramlab.behrupiya.presentation.ui.screens.History.Compnent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun HistoryTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically // Align items vertically in the center of the Row
    ) {
        // First image at the start
        Image(
            painter = painterResource(id = R.drawable.back_icn),
            contentDescription = null,
            modifier = Modifier
                .clickable { }
                .padding(start = 20.dp) // Adding padding to the image for spacing
        )

        // Spacer to push the text to the center
        Spacer(modifier = Modifier.weight(1f))

        // Text in the center
        Text(
            text = "History",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )

        // Spacer to push the second image to the end
        Spacer(modifier = Modifier.weight(1f))

        // Second image at the end
        Image(
            painter = painterResource(id = R.drawable.check),
            contentDescription = null,
            modifier = Modifier
                .clickable { }
                .padding(end = 20.dp)
        )
    }
}
