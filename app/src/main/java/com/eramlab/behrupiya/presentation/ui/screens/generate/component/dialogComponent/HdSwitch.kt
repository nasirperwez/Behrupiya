package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R

@Composable
fun HdSwitch(modifier: Modifier = Modifier) {
    var isFirstSwitchChecked by remember { mutableStateOf(false) }
    var isSecondSwitchChecked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Watermark switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                stringResource(R.string.Watermark),
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Switch(
                checked = isFirstSwitchChecked,
                onCheckedChange = {
                    isFirstSwitchChecked = it
                    if (it) isSecondSwitchChecked = false
                }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // HD Quality switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                stringResource(id = R.string.HdQuality),
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Switch(
                checked = isSecondSwitchChecked,
                onCheckedChange = {
                    isSecondSwitchChecked = it
                    if (it) isFirstSwitchChecked = false
                }
            )
        }
    }
}
