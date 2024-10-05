package com.eramlab.behrupiya.presentation.ui.screens.transparentDialog

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.activity.result.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    val cameraLauncher = rememberCameraLauncher(sharedViewModel, navController) { bitmap = it }
    val permissionLauncher = rememberPermissionLauncher(sharedViewModel, context, cameraLauncher)
    val galleryLauncher = rememberGalleryLauncher(sharedViewModel, navController,context) { bitmap ->
        sharedViewModel.setBitmap(bitmap)
        navController.navigate(NavigationRoutes.GENERATE_SCREEN)
    }

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
                .clickable(onClick = onDismiss)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                ImagePreviewCard(
                    modifier = Modifier
                        .weight(0.6f)
                        .fillMaxWidth(),
                    bitmap = bitmap
                )
                Spacer(modifier = Modifier.height(16.dp))

                ActionButton(modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth()
                    .weight(.2f),
                    text = "Take a photo",
                    iconResId = R.drawable.takepic_icn,
                    onClick = {
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
                Spacer(modifier = Modifier.padding(top = 22.dp))

                ActionButton(
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                        .weight(0.2f),
                    text = "Choose from gallery",
                    iconResId = R.drawable.chooseg_icn,
                    onClick = {
                        galleryLauncher.launch("image/*")
                    }
                )
            }
            CloseButton(
                navController,
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = onDismiss
            )
        }
    }
}