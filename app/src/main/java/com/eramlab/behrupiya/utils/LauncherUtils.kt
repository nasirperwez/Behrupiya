package com.eramlab.behrupiya.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun rememberCameraLauncher(sharedViewModel: SharedViewModel ,
                           navController: NavController,
                           onImageCaptured: (Bitmap) -> Unit): ActivityResultLauncher<Void?> =
    rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { imageBitmap ->
        imageBitmap?.let{
            sharedViewModel.setBitmap(imageBitmap)
        navController.navigate(NavigationRoutes.GENERATE_SCREEN)
    }
}

@Composable
fun rememberPermissionLauncher(
    sharedViewModel: SharedViewModel,
    context: Context,
    cameraLauncher: ActivityResultLauncher<Void?>
): ActivityResultLauncher<String> =
    rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            cameraLauncher.launch()
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

@Composable
fun rememberGalleryLauncher(
    context: Context,
    onImageSelected: (Bitmap) -> Unit
): ActivityResultLauncher<String> =
    rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val inputStream = context.contentResolver.openInputStream(it)
            inputStream?.use { stream ->
                BitmapFactory.decodeStream(stream)?.let(onImageSelected)
            }
        }
    }

