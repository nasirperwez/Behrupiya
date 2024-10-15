package com.eramlab.behrupiya.utils

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64
import java.util.Random
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import android.provider.Settings
import java.util.UUID
import android.content.Context
import java.security.SecureRandom


@RequiresApi(Build.VERSION_CODES.O)
fun encryptData(plainText: String, sharedKey: String): String {
    // Create SHA-256 hash of the shared key
    val key = MessageDigest.getInstance("SHA-256").digest(sharedKey.toByteArray())

    // Generate a random IV
    val iv = ByteArray(16)
    SecureRandom().nextBytes(iv)

    // Initialize the cipher for AES in CBC mode with PKCS5 padding
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val secretKey = SecretKeySpec(key, "AES")
    val ivSpec = IvParameterSpec(iv)
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec)

    // Encrypt the plaintext
    val encryptedData = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))

    // Combine IV and ciphertext
    val combinedData = iv + encryptedData
    val test = Base64.getEncoder().encodeToString(combinedData)
    println(test)
    // Encode the combined data as Base64 without line breaks
    return Base64.getEncoder().encodeToString(combinedData)
}


fun getUniqueDeviceId(context: Context): String {
    val androidId = Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    return if (androidId == "9774d56d682e549c" || androidId.isEmpty()) {
        // For Android < 2.2 or when ANDROID_ID returns the default reserved value
        UUID.randomUUID().toString()
    } else {
        androidId
    }
}

class KeyStoreManager(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("ApiKeyPrefs", Context.MODE_PRIVATE)
    private val apiKeyKey = "api_key"

    fun storeApiKey(apiKey: String) {
        sharedPreferences.edit().putString(apiKeyKey, apiKey).apply()
        Log.d("SimpleApiKeyManager", "API key stored successfully")
    }

    fun getApiKey(): String? {
        val apiKey = sharedPreferences.getString(apiKeyKey, null)
        if (apiKey == null) {
            Log.d("SimpleApiKeyManager", "No API key found")

        } else {
            Log.d("SimpleApiKeyManager", "API key retrieved successfully")
        }
        return apiKey
    }
}