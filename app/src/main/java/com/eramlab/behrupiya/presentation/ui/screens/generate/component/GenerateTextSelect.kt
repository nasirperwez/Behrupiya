package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun GenerateTextSelect() {
    var expandedCulture by remember { mutableStateOf(false) }

    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedCulture by remember { mutableStateOf("") }

    val countryIcon =
        if (expandedCulture) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Box(
        modifier = Modifier
            .fillMaxWidth(0.40f)
            .aspectRatio(4f) // This creates a fixed aspect ratio, replacing the need for padding
            .clickable { expandedCulture = !expandedCulture }
            .background(color = Color.Transparent)
        //.border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(4.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedCulture,
                modifier = Modifier.weight(1f),
                fontSize = 20.sp,
                color = Color.White
            )
            Icon(
                imageVector = countryIcon,
                contentDescription = null,
                tint = Color.White // Set icon color to white
            )
        }
        DropdownMenu(
            expanded = expandedCulture,
            onDismissRequest = { expandedCulture = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedCulture = option
                        expandedCulture = false
                    }
                )
            }
        }
    }
}



