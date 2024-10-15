package com.eramlab.behrupiya.data.network

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File


class Repository(private val context: Context , private val networkLayer: NetworkLayer) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun registerUser(deviceId: String) = networkLayer.registerUser(context ,deviceId)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun generateImage(apiKey: String,prompt: String, imagePath: File) =
        networkLayer.generateImagesev(apiKey,  prompt, imagePath)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getPrompts(apiKey: String) = networkLayer.getPrompt()
}
