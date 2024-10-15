package com.eramlab.behrupiya.presentation.ui.splash

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.utils.NavigationRoutes
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
<<<<<<< HEAD
import androidx.compose.ui.res.stringResource
=======
import androidx.compose.ui.platform.LocalContext
>>>>>>> origin/Abhi_ServerChange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.data.network.NetworkLayer
import com.eramlab.behrupiya.presentation.ui.components.Animation
import com.eramlab.behrupiya.presentation.ui.theme.raleway_regular
import com.eramlab.behrupiya.utils.KeyStoreManager


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SplashScreen(
    navController: NavController,
    //  splashViewModel: SplashViewModel = viewModel()
) {
    // Delay and navigate to the OnboardingScreen
    val context = LocalContext.current
    val networkLayer = NetworkLayer()
    LaunchedEffect(Unit) {
        val newkey = KeyStoreManager(context).getOrCreateSecretKey()
        println(newkey)
        val apiKey = networkLayer.registerUser(context,"D123467")
        println("apiKey   = " + apiKey )
        delay(5000L)
        // Navigate to the OnboardingScreen
        navController.navigate(NavigationRoutes.ONBOARDING1) {
            // Clears the back stack so the user can't navigate back to the splash screen
            popUpTo(NavigationRoutes.SPLASH) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.CenterVertically), // Center the Column vertically
            horizontalAlignment = Alignment.CenterHorizontally // Center the items in the Column horizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.centre_img),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.centre_logo),
                contentDescription = null,
                modifier = Modifier.offset(y = (-16).dp)
            )
            Animation()
            Spacer(modifier = Modifier.weight(1f)) // Take up available space
            Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Row {
                    Text(
                        stringResource(R.string.Promote) + " ",
                        fontFamily = raleway_regular,
                        color = Color(0xFF2563EB),
                        fontSize = 12.sp
                    )
                    Text(
                        stringResource(R.string.lab),
                        color = Color(0xFF00FFFC),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.clickable { }
                    )
                }
                Text(
                    stringResource(R.string.year),
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )


            }

        }
    }
}

