package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent.SheareandOtherApp

@Composable
fun SocialMedia(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SheareandOtherApp(modifier)
    }
}