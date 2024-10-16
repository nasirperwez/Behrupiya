package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import kotlinx.coroutines.delay


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GenerateAndsave(
    isGeneration:Int,
    sharedViewModel: SharedViewModel,
    generateImageViewModel: GenerateImageViewModel,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val test = generateImageViewModel.getGenerating()
        println(test)
        if (isGeneration== 0 || isGeneration ==2) {
            GenerateAndSaveBox(
                isGeneration,
                sharedViewModel, generateImageViewModel, onGenerateClick = {
                generateImageViewModel.setGenerating(1) // Set loading state to 1 on click
            })
            Spacer(modifier = Modifier.padding(top = 15.dp))
            SaveAndShareBox(sharedViewModel = sharedViewModel) // Pass the sharedViewModel here
        } else {
            // Show loading wrapper when loading
            LoadingWrapper(isGeneration, modifier = Modifier, onLoadingComplete = {
                generateImageViewModel.setGenerating(0)
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

//    LaunchedEffect(isLoading) {
//        if (isLoading == 1) {
//            delay(30000L) // 30 seconds delay
//            showProgress = false
//            onLoadingComplete()
//        }
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading == 1) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (showProgress) {
                    EnhancedLinearProgressIndicator()
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

@Composable
fun EnhancedLinearProgressIndicator() {
    var progress by remember { mutableStateOf(0f) }
    var pulseScale by remember { mutableStateOf(1f) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000) // Smooth animation
    )
    val animatedScale by animateFloatAsState(
        targetValue = pulseScale,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = LinearEasing), // Repeating pulse animation
            repeatMode = RepeatMode.Reverse
        )
    )
    LaunchedEffect(Unit) {
        while (true) {
            progress = if (progress >= 1f) 0f else progress + 0.1f
            pulseScale = if (pulseScale == 1f) 1.2f else 1f // Alternate pulse scale
            delay(2000) // Update progress every second
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .scale(animatedScale), // Applying the pulse effect here
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator(
            progress = animatedProgress,
            color = Color(0xFF0357C0),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}