package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OfferBoxSection(selectedBox: Int, onSelect: (Int) -> Unit, modifier: Modifier=Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OfferBox(
            selected = selectedBox == 0,
            price = "INR 79.00",
            period = "per week",
            yearAccess = "YEAR ACCESS",
            fullPrice = "Just ₹ 3,999.00",
            year = "per year",
            onClick = { onSelect(0) }
        )
        OfferBox(
            selected = selectedBox == 1,
            price = "INR 120.00",
            period = "per week",
            yearAccess = "YEAR ACCESS",
            fullPrice = "Just ₹ 3,999.00",
            year="per year",
            onClick = { onSelect(1) }
        )
    }
}