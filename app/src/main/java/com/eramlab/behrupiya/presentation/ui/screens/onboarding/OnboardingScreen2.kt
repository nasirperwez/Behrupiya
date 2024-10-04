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
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent1.OnboardingContent1
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent1.OnboardingHeader1
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent2.OnboardingContent2
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent2.OnboardingHeader2

@Composable
fun OnboardingScreen2(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.tuts_bg2),
        contentDescription = "Splash Logo", modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OnboardingHeader2(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.65f)
        )
        OnboardingContent2(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.35f)
        )
    }
}