package com.eramlab.behrupiya.presentation.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent3.OnboardingContent3
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent3.OnboardingHeader3

@Composable
fun OnboardingScreen3(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.bg_img3_2x),
        contentDescription = "Splash Logo", modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OnboardingHeader3(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.65f)
        )
        OnboardingContent3(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.35f)
        )
    }
}