package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HdSwitch(modifier: Modifier) {
    var isFirstSwitchChecked by remember { mutableStateOf(false) }
    var isSecondSwitchChecked by remember { mutableStateOf(false) }
    Row(modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Watermark",
            modifier = Modifier,
            color = Color.White
        )
        Switch(
            checked = isFirstSwitchChecked, onCheckedChange = {
                isFirstSwitchChecked = it
                if (it) {
                    isSecondSwitchChecked = false
                }
            }, modifier = Modifier
        )

        Text(
            text = "HD Quality",
            modifier = Modifier,
            color = Color.White
        )
        Switch(
            checked = isSecondSwitchChecked, onCheckedChange = {
                isSecondSwitchChecked = it
                if (it) {
                    isFirstSwitchChecked = false
                }
            }, modifier = Modifier
        )

    }
}