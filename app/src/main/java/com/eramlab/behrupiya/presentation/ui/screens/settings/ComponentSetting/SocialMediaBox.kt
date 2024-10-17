package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun SocialMediaBox(navController: NavController, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(color = Color(0xFF222121))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            SettingLanguage(
                navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.9f)
            )
//            SocialMedia(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//                    .weight(0.1f)
//            )
        }
    }
}
