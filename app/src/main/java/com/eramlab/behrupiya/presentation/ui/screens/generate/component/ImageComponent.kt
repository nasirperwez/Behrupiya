package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave.GenerateAndSaveBox
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave.SaveAndShareBox
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import kotlinx.coroutines.delay


@Composable
fun GenerateAndsave(
    sharedViewModel: SharedViewModel,
    generateImageViewModel: GenerateImageViewModel,
    modifier: Modifier = Modifier
) {
    var isLoading by remember { mutableStateOf(0) } // Using 0 and 1 for loading state

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if (isLoading == 0) {
            GenerateAndSaveBox(sharedViewModel, generateImageViewModel, onGenerateClick = {
                isLoading = 1 // Set loading state to 1 on click
            })
            Spacer(modifier = Modifier.padding(top = 15.dp))
            SaveAndShareBox(sharedViewModel = sharedViewModel) // Pass the sharedViewModel here
        } else {
            // Show loading wrapper when loading
            LoadingWrapper(isLoading = 1, modifier = Modifier, onLoadingComplete = {
                isLoading = 0
            })
        }
    }
}


@Composable
fun LoadingWrapper(
    isLoading: Int, modifier: Modifier = Modifier, onLoadingComplete: () -> Unit

) {
    var showProgress by remember { mutableStateOf(true) }
    var currentIndex by remember { mutableStateOf(0) }

    val texts = listOf(
        "You can always request an AI filter that we don't have yet via support",
        "You can always request an AI filter that ",
        "You can always request an AI filter that we don't"
    )


    LaunchedEffect(isLoading) {
        if (isLoading == 1) {
            delay(30000L) // 30 seconds delay
            showProgress = false
            onLoadingComplete()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading == 1) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (showProgress) {
                    LinearProgressIndicator(
                        color = Color.Blue,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = modifier.height(16.dp))
                }
                Text(
                    stringResource(R.string.UsefulTips),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth() // Fill the width to space out items
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                        }
                    }, modifier = Modifier) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Left click",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = texts[currentIndex],
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(0.80f)
                    )

                    IconButton(onClick = {
                        if (currentIndex < texts.size - 1) {
                            currentIndex++
                        }
                    }, modifier = Modifier) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Right click",
                            tint = Color.White
                        )
                    }
                }

            }
        }
    }
}