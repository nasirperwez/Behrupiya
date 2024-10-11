package com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent2

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.utils.NavigationRoutes

@Composable
fun OnboardingHeader2(navController: NavController, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.img3_2x),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 25.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Skip>>",
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { navController.navigate(NavigationRoutes.HOME) },
                color = Color.White
            )
        }
    }
}