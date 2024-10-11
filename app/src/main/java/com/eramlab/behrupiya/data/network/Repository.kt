package com.eramlab.behrupiya.data.network

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi



class Repository(private val context: Context , private val networkLayer: NetworkLayer) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun registerUser(deviceId: String) = networkLayer.registerUser(context ,deviceId)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun generateImage(apiKey: String, imagePath: String, prompt: String, negativePrompt: String, style: String) =
        networkLayer.generateImage(apiKey, imagePath, prompt, negativePrompt, style)
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getPrompts(apiKey: String) = networkLayer.getPrompts(apiKey)
}
