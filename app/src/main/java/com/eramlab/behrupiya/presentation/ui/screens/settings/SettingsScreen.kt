package com.eramlab.behrupiya.presentation.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.BottomTaskbar
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.TopBar
import com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting.FollowDiscord
import com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting.SocialMediaBox
import com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting.TopBarSetting

@Composable
fun SettingsScreen(
    sharedViewModel: SharedViewModel, navController: NavController, onMDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF0A0808))
    ) {
//            Image(
//                painter = painterResource(id = R.drawable.behrupiya_dashboard_15),
//                contentDescription = null, modifier = Modifier.fillMaxSize()
//            )
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBarSetting(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.1f)
            )
            SocialMediaBox(
                navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.9f),
            )

        }
        BottomTaskbar(
            sharedViewModel,
            navController,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 0.dp)
        )

    }
}
