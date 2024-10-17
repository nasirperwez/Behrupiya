package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.TransparentDialog
import com.eramlab.behrupiya.presentation.ui.settings.SettingsScreen
import com.eramlab.behrupiya.utils.NavigationRoutes


@Composable
fun BottomTaskbar(
    sharedViewModel: SharedViewModel,
    navController: NavController, modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    var settingDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF000000))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TaskbarIcon(
                R.drawable.home_footer_icn_s,
                onClick = {
                    navController.navigate(NavigationRoutes.HOME) {
                        popUpTo(NavigationRoutes.HOME) { inclusive = true }
                    }
                }
            )
            TaskbarIcon(
                R.drawable.camera_icn,
                onClick = {
                    navController.navigate(NavigationRoutes.TRANSPARENTDIALOG) {
                        popUpTo(NavigationRoutes.HOME) { inclusive = true }
                    }
                },
                size = 70.dp
            )

            TaskbarIcon(
                R.drawable.setting_footer_icn_s,
                onClick = {
                    navController.navigate(NavigationRoutes.SETTING) {
                        popUpTo(NavigationRoutes.HOME) { inclusive = true }
                    }
                }
            )

        }
    }
}