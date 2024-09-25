package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OfferBoxSection(selectedBox: Int, onSelect: (Int) -> Unit, modifier: Modifier=Modifier) {
    var selectedBox by remember { mutableStateOf(-1) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OfferBox(
            selected = selectedBox == 1,
            price = "INR 79.00",
            period = "per week",
            yearAccess = "YEAR ACCESS",
            fullPrice = "Just ₹ 3,999.00",
            year = "per year",
            isFirstBox = true,
            onClick = { selectedBox = 1 }
        )
        OfferBox(
            selected = selectedBox == 2,
            price = "INR 120.00",
            period = "per week",
            yearAccess = "YEAR ACCESS",
            fullPrice = "Just ₹ 3,999.00",
            year="per year",
            isSecondBox = true,
            onClick = { selectedBox = 2 }

        )
    }
}