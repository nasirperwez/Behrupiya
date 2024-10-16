package com.eramlab.behrupiya.presentation.ui.screens.History

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.History.Compnent.HistoryTopBar
import com.eramlab.behrupiya.presentation.ui.screens.History.Component.HistoryImage
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel

@Composable
fun HistoryScreen(
    homeViewModel: HomeViewModel,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xF2242323))
    ) {
        HistoryTopBar(
            navController,
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