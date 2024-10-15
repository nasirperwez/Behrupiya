package com.eramlab.behrupiya.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.eramlab.behrupiya.presentation.SharedViewModel
import androidx.core.content.FileProvider
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext




@Composable
fun rememberCameraLauncher(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    context: Context,
    onImageCaptured: (Bitmap) -> Unit
): ActivityResultLauncher<Uri> {
    // Create a file for storing the image
    val imageUri = remember {
        val imageFile = File(context.filesDir, "captured_image.jpg")
        FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            imageFile
        )
    }

    return rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            // Convert Uri to Bitmap
            val bitmap = context.contentResolver.openInputStream(imageUri)?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }

            bitmap?.let {
                // Pass the Bitmap to the callback
                onImageCaptured(it)
                // Set the Bitmap in the shared ViewModel
                sharedViewModel.setBitmap(it)
                navController.navigate(NavigationRoutes.GENERATE_SCREEN)
            }
        } else {
            Toast.makeText(context, "Image capture failed", Toast.LENGTH_SHORT).show()
        }
    }
}















//@Composable
//fun rememberCameraLauncher(sharedViewModel: SharedViewModel ,
//                           navController: NavController,
//                           onImageCaptured: (Bitmap) -> Unit): ActivityResultLauncher<Void?> =
//    rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { imageBitmap ->
//        imageBitmap?.let{
//            sharedViewModel.setBitmap(imageBitmap)
//        navController.navigate(NavigationRoutes.GENERATE_SCREEN)
//    }
//}
//




@Composable
fun rememberPermissionLauncher(
    sharedViewModel: SharedViewModel,
    context: Context,
    cameraLauncher: ActivityResultLauncher<Uri>
): ActivityResultLauncher<String> =
    rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            // Create a file Uri where the high-quality image will be stored
            val imageUri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                File(context.filesDir, "captured_image.jpg")
            )

            // Launch the camera with the provided Uri to save the image
            cameraLauncher.launch(imageUri)
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }



@Composable
fun rememberGalleryLauncher(
    sharedViewModel: SharedViewModel ,
    navController: NavController,
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

