package com.eramlab.behrupiya.presentation.ui.screens.History

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.History.Compnent.HistoryTopBar
import com.eramlab.behrupiya.presentation.ui.screens.History.Component.HistoryImage
import com.eramlab.behrupiya.presentation.viewmodel.HistoryImageViewModel
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel

@Composable
fun HistoryScreen(
    historyImageViewModel: HistoryImageViewModel,
    homeViewModel: HomeViewModel,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {

    val imageList by historyImageViewModel.imageFiles.collectAsState()

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
            historyImageViewModel,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.9f)
        )
    }
}