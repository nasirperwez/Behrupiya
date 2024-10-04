package com.eramlab.behrupiya.presentation.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent1.OnboardingContent1
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent1.OnboardingHeader1

@Composable
fun OnboardingScreen1(
    navController: NavController,
  //  onboardingViewModel: OnboardingViewModel = viewModel()
) {
   // val onboardingState by onboardingViewModel.onboardingState.collectAsState()
    Image(
        painter = painterResource(id = R.drawable.bg_img1_3x),
        contentDescription = "Splash Logo", modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OnboardingHeader1(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.65f)
        )
        OnboardingContent1(
            navController, modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(.35f)
        )
    }
}
