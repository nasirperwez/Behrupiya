package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R

@Composable
fun SettingLanguage(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(30.dp))

        SettingOptionItem(
            iconId = R.drawable.icn1_select_language,
            text = "Select Language"
        )

        SettingOptionItem(
            iconId = R.drawable.icn2_share_app,
            text = "Share App"
        )

        SettingOptionItem(
            iconId = R.drawable.icn3_style_request,
            text = "Style request"
        )

        SettingOptionItem(
            iconId = R.drawable.icn4_privacy,
            text = "Privacy"
        )

        SettingOptionItem(
            iconId = R.drawable.icn5_contact_us,
            text = "Terms & Conditions"
        )

        SettingOptionItem(
            iconId = R.drawable.icn6_consent,
            text = "Contact Us"
        )

        SettingOptionItem(
            iconId = R.drawable.icn6_lock,
            text = "Consent"
        )
    }
}

@Composable
fun SettingOptionItem(iconId: Int, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = 15.dp)) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(text = text, color = Color.White)
    }
}
