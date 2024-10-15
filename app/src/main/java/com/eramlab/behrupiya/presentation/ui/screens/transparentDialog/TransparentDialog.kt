package com.eramlab.behrupiya.presentation.ui.screens.transparentDialog

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.activity.result.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.component.ActionButton
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.component.CloseButton
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.component.ImagePreviewCard
import com.eramlab.behrupiya.utils.NavigationRoutes
import com.eramlab.behrupiya.utils.rememberCameraLauncher
import com.eramlab.behrupiya.utils.rememberGalleryLauncher
import com.eramlab.behrupiya.utils.rememberPermissionLauncher

@Composable
fun TransparentDialog(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    onDismiss: () -> Unit
) {
    var clickedButtonIndex by remember { mutableStateOf(-1) }

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    val cameraLauncher = rememberCameraLauncher(sharedViewModel, navController) { bitmap = it }
    val permissionLauncher = rememberPermissionLauncher(sharedViewModel, context, cameraLauncher)
    val galleryLauncher =
        rememberGalleryLauncher(sharedViewModel, navController, context) { bitmap ->
            sharedViewModel.setBitmap(bitmap)
            navController.navigate(NavigationRoutes.GENERATE_SCREEN)
        }
    val buttonWidth = 280.dp

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x80000000))
            //.clickable(onClick = onDismiss)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImagePreviewCard(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(0.6f)
                        .fillMaxWidth(),
                    bitmap = bitmap
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

                ActionButton(modifier = Modifier
                    .padding(10.dp) // Reduced padding
                    .width(buttonWidth)
                    .weight(0.125f),
                    text = "Take a photo",
                    iconResId = if (clickedButtonIndex == 1) R.drawable.takepic_icn_s else R.drawable.takepic_icn,
                    isSelected = clickedButtonIndex == 1,
                    onClick = {
                        clickedButtonIndex = 1
                        when {
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.CAMERA
                            ) == PackageManager.PERMISSION_GRANTED -> {
                                cameraLauncher.launch()
                            }
                            else -> {
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        }
                    }
                )

                ActionButton(
                    modifier = Modifier
                        .padding(10.dp) // Reduced padding
                        .width(buttonWidth)
                        .weight(0.125f),
                    text = "Choose from gallery",
                    iconResId = if (clickedButtonIndex == 2) R.drawable.chooseg_icn_s else R.drawable.chooseg_icn,
                    isSelected = clickedButtonIndex == 2,
                    onClick = {
                        clickedButtonIndex = 2
                       galleryLauncher.launch("image/*")
                    },
                )
                Spacer(modifier = Modifier.padding(top = 30.dp))
            }
            CloseButton(
                navController,
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = onDismiss
            )
        }
    }
}