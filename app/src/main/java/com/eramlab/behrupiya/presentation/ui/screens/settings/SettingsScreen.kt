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
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.component.TopBar
import com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting.FollowDiscord
import com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting.SocialMediaBox

@Composable
fun SettingsScreen(
    onMDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onMDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false,
        )
    ) {
        Box(
            modifier = Modifier.padding(bottom = 60.dp)
                .fillMaxSize()
                .background(color = Color(0xFF222121))
                .clickable(onClick = onMDismiss)
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.behrupiya_dashboard_15),
//                contentDescription = null, modifier = Modifier.fillMaxSize()
//            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.1f)
                )
                FollowDiscord(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.1f)
                )
                SocialMediaBox(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.8f))

            }

        }
    }
}
