package com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FeatureListSection(modifier: Modifier=Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 25.dp),
        horizontalAlignment = Alignment.Start
    ) {
        FeatureRow("Unlimated Daily Conversions")
        FeatureRow("Fast Filter Processing")
        FeatureRow("No Watermark")
        FeatureRow("Remove Ads & no limits")
    }
}