package com.eramlab.behrupiya.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.eramlab.behrupiya.presentation.ui.screens.History.HistoryScreen
import com.eramlab.behrupiya.presentation.ui.screens.generate.GenerateImageScreen
import com.eramlab.behrupiya.presentation.ui.screens.premium.PreminumScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
               // ControlNav()
                HistoryScreen()
            }
        }
    }
}
