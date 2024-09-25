package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTopbarComponent.backButton
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTopbarComponent.categoryFilters
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateTopbarComponent.imageIcon


@Composable
fun GenerateTopbar(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xC31E1EA7))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            backButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.2f)
            )

            categoryFilters(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.7f)
            )
            imageIcon(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.1f)
            )
        }
    }
}
