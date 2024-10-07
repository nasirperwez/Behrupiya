package com.eramlab.behrupiya.data.network

class Repository(private val networkLayer: NetworkLayer) {
    suspend fun registerUser(deviceId: String) = networkLayer.registerUser(deviceId)
    suspend fun generateImage(apiKey: String, imagePath: String, prompt: String, negativePrompt: String, style: String) =
        networkLayer.generateImage(apiKey, imagePath, prompt, negativePrompt, style)
    suspend fun getPrompts(apiKey: String) = networkLayer.getPrompts(apiKey)
}
