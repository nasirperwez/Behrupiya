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
import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


object CryptoUtils {
    private val SHARED_SECRET_KEY = System.getenv("SHARED_SECRET_KEY").toByteArray()

    @RequiresApi(Build.VERSION_CODES.O)
    fun encryptData(plainText: String): String {
        val key = MessageDigest.getInstance("SHA-256").digest(SHARED_SECRET_KEY)
        val iv = ByteArray(16)
        Random().nextBytes(iv)

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), IvParameterSpec(iv))

        val encrypted = cipher.doFinal(plainText.toByteArray())
        return Base64.getEncoder().encodeToString(iv + encrypted)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun generateEncryptedData(): String {
    val timestamp = System.currentTimeMillis().toString()
    return CryptoUtils.encryptData(timestamp)
}



class KeyStoreManager(private val context: Context) {
    private val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
    private val keyAlias = "ApiKeyAlias"

    fun storeApiKey(apiKey: String) {
        val secretKey = getOrCreateSecretKey()
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedApiKey = cipher.doFinal(apiKey.toByteArray(Charsets.UTF_8))
        val sharedPrefs = context.getSharedPreferences("ApiKeyPrefs", Context.MODE_PRIVATE)
        sharedPrefs.edit().putString("encrypted_api_key", encryptedApiKey.toString(Charsets.ISO_8859_1)).apply()
    }

    fun getOrCreateSecretKey(): SecretKey {
        return if (keyStore.containsAlias(keyAlias)) {
            keyStore.getKey(keyAlias, null) as SecretKey
        } else {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(keyAlias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()
            keyGenerator.init(keyGenParameterSpec)
            keyGenerator.generateKey()
        }
    }
}