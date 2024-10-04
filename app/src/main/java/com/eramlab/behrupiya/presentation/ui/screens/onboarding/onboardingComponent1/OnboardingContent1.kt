package com.eramlab.behrupiya.presentation.ui.screens.onboarding.onboardingComponent1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.Components.TermsAndConditionsText1
import com.eramlab.behrupiya.utils.NavigationRoutes

@Composable
fun OnboardingContent1(navController: NavController, modifier: Modifier) {
    val blueGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0)) // Two colors for the gradient
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Generate New look",
            color = Color(0xFFD4E49A),
            fontSize = 34.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "from a ",
                color = Color(0xFFD4E49A),
                fontSize = 34.sp
            )
            Text(
                text = "single Selfie",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00F6EE),
                fontSize = 34.sp
            )
        }
        Text(
            text = "Anything. Any detail. Add your dreams lorem ipsum is simple use for dummy text purposes.",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(0.65f)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                navController.navigate(NavigationRoutes.ONBOARDING2) {
                    popUpTo(NavigationRoutes.ONBOARDING1) { inclusive = true }
                }
            },
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .width(330.dp)
                .height(50.dp)
                .background(blueGradient, shape = RoundedCornerShape(30.dp))
        ) {
            Text(text = "Next", fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(18.dp))
        TermsAndConditionsText1()
    }
}
