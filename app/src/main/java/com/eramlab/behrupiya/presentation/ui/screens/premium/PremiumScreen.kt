package com.eramlab.behrupiya.presentation.ui.screens.premium

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent.FeatureListSection
import com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent.FooterSection
import com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent.OfferBoxSection
import com.eramlab.behrupiya.presentation.ui.screens.premium.premiumComponent.TopSection
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.eramlab.behrupiya.R


@Composable
fun PreminumScreen() {
    var selectedBox by remember { mutableStateOf(-1) }
    Image(
        painter = painterResource(id = R.drawable.background_image),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
            contentScale = ContentScale.Crop

    )
    Column(
        modifier = Modifier
            .fillMaxSize()
        // .background(color = Color(0xD5080809))
    ) {
        TopSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)
        )
        FeatureListSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)
        )
        OfferBoxSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f),
            selectedBox = selectedBox,
            onSelect = { selectedBox = it })
        FooterSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)
        )
    }
}