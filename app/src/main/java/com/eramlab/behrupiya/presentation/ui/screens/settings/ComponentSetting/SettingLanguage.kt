package com.eramlab.behrupiya.presentation.ui.screens.settings.ComponentSetting

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextDecoration
import com.eramlab.behrupiya.R
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.eramlab.behrupiya.utils.NavigationRoutes

@Composable
fun SettingLanguage(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

//        SettingOptionItem(
//            iconId = R.drawable.icn1_select_language,
//            text = "Select Language"
//        )

        SettingOptionItem(
            iconId = R.drawable.icn2_share_app,
            text = "Share App",
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Check out this image: https://www.google.com")
                }
                val chooser = Intent.createChooser(shareIntent, "Share via")
                ContextCompat.startActivity(context, chooser, null)
            }
        )

//        SettingOptionItem(
//            iconId = R.drawable.icn3_style_request,
//            text = "Style request"
//        )

        SettingOptionItem(
            iconId = R.drawable.icn4_privacy,
            text = "Privacy and Policy",
            onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://behrupiya.s3.ap-south-1.amazonaws.com/docs/privacy.html")
                )
                context.startActivity(intent)
            }
        )

        SettingOptionItem(
            iconId = R.drawable.icn5_contact_us,
            text = "Terms & Conditions",
            onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://behrupiya.s3.ap-south-1.amazonaws.com/docs/terms.html")
                )
                context.startActivity(intent)
            }
        )

//        SettingOptionItem(
//            iconId = R.drawable.icn6_consent,
//            text = "Contact Us"
//        )

        SettingOptionItem(
            iconId = R.drawable.icn6_lock,
            text = "About ac",
            onClick = {
                showDialog = true
            }
        )
        if (showDialog) {
            TransparentOverlay(onDismiss = { showDialog = false })
        }
        SettingOptionItem(
            iconId = R.drawable.history,
            text = "History",
            onClick = { navController.navigate(NavigationRoutes.HISTORY) }
        )
    }
}

@Composable
fun SettingOptionItem(
    iconId: Int,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(modifier = modifier.padding(vertical = 15.dp)) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.clickable(onClick = onClick),
            textDecoration = TextDecoration.None
        )
    }
}

@Composable
fun TransparentOverlay(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            dismissOnClickOutside = true
        )
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(Color(0x80000000)) // Semi-transparent background
                .clickable { onDismiss() }, // Dismiss when clicking outside
            contentAlignment = Alignment.Center
        ) {
            // Popup content
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.about_us_popup),
                    contentDescription = null,
                )
            }
        }
    }
}