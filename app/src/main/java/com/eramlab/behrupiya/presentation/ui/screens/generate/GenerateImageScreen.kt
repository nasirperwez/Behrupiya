package com.eramlab.behrupiya.presentation.ui.screens.generate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateCard
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave



@Composable
fun GenerateImageScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xC3202027))
    )
    {
        GenerateAndSave(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.75f)
        )
        GenerateCard(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.25f)


        )

    }
}

