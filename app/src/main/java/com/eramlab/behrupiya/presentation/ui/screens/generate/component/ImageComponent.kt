package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave.GenerateAndSaveBox
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave.GenerateBox
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel

@Composable
fun GenerateAndsave(
    sharedViewModel: SharedViewModel,
    generateImageViewModel: GenerateImageViewModel,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
        GenerateAndSaveBox(
            sharedViewModel,
            generateImageViewModel)
        Spacer(modifier = Modifier.padding(top = 15.dp))
        GenerateBox()
    }
}





