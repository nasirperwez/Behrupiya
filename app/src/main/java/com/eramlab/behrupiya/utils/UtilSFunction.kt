package com.eramlab.behrupiya.utils

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64
import java.util.Random

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