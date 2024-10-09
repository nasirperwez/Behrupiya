package com.eramlab.behrupiya.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//data class CategoryData(
//    val category: String,
//    val items: List<Item>
//)
//
//@Serializable
//data class Item(
//    val id: Int,
//    val title: String,
//    val imageUrl: String,
//)

@Serializable
data class CategoryData(
    val name: String,
    val effects: List<Item>
)


@Serializable
data class Item(
    val effect_id: String,
    val name: String,
    val prompt: String,
    @SerialName("output_image")val output_image: String? = null
)



@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: RegisterData?
)

@Serializable
data class RegisterData(
    @SerialName("api_key") val apiKey: String?
)


@Serializable
data class GenerateImageResponse(val imageUrl: String)

@Serializable
data class User(val id: String, val deviceId: String)

@Serializable
data class RequestLog(val id: String, val userId: String, val requestType: String, val timestamp: Long)

@Serializable
data class Prompt(val id: String, val text: String)



