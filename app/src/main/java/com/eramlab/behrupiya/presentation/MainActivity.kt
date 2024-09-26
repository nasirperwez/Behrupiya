package com.eramlab.behrupiya.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.eramlab.behrupiya.presentation.ui.screens.generate.GenerateImageScreen
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.HomeScreen
import com.eramlab.behrupiya.presentation.ui.screens.premium.PreminumScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
   //                 GenerateImageScreen()
//                    GenerateImageScreennasir()
                   // PreminumScreen()
                }
            }
        }
    }
}

