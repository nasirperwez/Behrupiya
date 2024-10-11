package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.SharedViewModel

@Composable
fun SheareandOtherApp(modifier: Modifier, sharedViewModel: SharedViewModel) {
    val context = LocalContext.current

    Row(
        modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.social_whasapp),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    val bitmap = sharedViewModel.bitmap.value
                    bitmap?.let { btm ->
                        // Convert bitmap to URI or file and share
                        val uri = saveImageToCache(context, btm)

                        uri?.let {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "image/png" // Specify the image type
                                putExtra(Intent.EXTRA_STREAM, it) // Pass the image URI
                                putExtra(Intent.EXTRA_TEXT, "Check out this image: https://www.google.com") // Add text and Google link
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            val chooser = Intent.createChooser(shareIntent, "Share Image via")
                            ContextCompat.startActivity(context, chooser, null)
                        }
                    }
                })
        Image(painter = painterResource(id = R.drawable.social_facebook),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .size(40.dp)
                .clickable {
                    val bitmap = sharedViewModel.bitmap.value
                    bitmap?.let { btm ->
                        // Convert bitmap to URI or file and share
                        val uri = saveImageToCache(context, btm)

                        uri?.let {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "image/png" // Specify the image type
                                putExtra(Intent.EXTRA_STREAM, it) // Pass the image URI
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            val chooser = Intent.createChooser(shareIntent, "Share Image via")
                            ContextCompat.startActivity(context, chooser, null)
                        }
                    }
                }

        )
        Image(painter = painterResource(id = R.drawable.social_instgram),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .size(40.dp)
                .clickable {
                    val bitmap = sharedViewModel.bitmap.value
                    bitmap?.let { btm ->
                        // Convert bitmap to URI or file and share
                        val uri = saveImageToCache(context, btm)

                        uri?.let {
                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                type = "image/png" // Specify the image type
                                putExtra(Intent.EXTRA_STREAM, it) // Pass the image URI
                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                            }
                            val chooser = Intent.createChooser(shareIntent, "Share Image via")
                            ContextCompat.startActivity(context, chooser, null)
                        }
                    }
                }

        )
    }
}

fun saveImageToCache(context: Context, bitmap: android.graphics.Bitmap): android.net.Uri? {
    return try {
        // Create a file in the cache directory
        val cachePath = java.io.File(context.cacheDir, "images")
        cachePath.mkdirs() // Create the directory if it doesn't exist
        val file = java.io.File(cachePath, "shared_image.png") // Image file name
        val stream = java.io.FileOutputStream(file)
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()

        // Use FileProvider to get the URI
        androidx.core.content.FileProvider.getUriForFile(
            context, "${context.packageName}.fileprovider", // authority
            file
        )
    } catch (e: java.io.IOException) {
        e.printStackTrace()
        null
    }
}
