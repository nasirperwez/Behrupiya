package com.eramlab.behrupiya.presentation.ui.screens.History

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eramlab.behrupiya.presentation.ui.screens.History.Compnent.HistoryTopBar
import com.eramlab.behrupiya.presentation.ui.screens.History.Component.HistoryImage

@Composable
fun HistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xF2242323))
    ) {
        HistoryTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        )
        HistoryImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.9f)
        )
    }
}