package com.eramlab.behrupiya.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable



//// Get hader Data
//@Serializable
//data class PromptsResponseHeader(
//    val success: Boolean,
//    val message: String,
//    val data: PromptDataHeader
//)
//
//@Serializable
//data class PromptDataHeader(
//    val prompts: CategoryListHeader
//)
//
//@Serializable
//data class CategoryListHeader(
//    val categories: List<CategoryDataHeader>
//)
//
//@Serializable
//data class CategoryDataHeader(
//    val name: String,
//    val category_id: String,
//    val effects: List<ItemHeader>
//)
//
//
//@Serializable
//data class ItemHeader(
//    val name: String,
//    val prompt: String,
//    val gender: String,
//    @SerialName("source_image")val output_image: String? = null,
//    val effect_id: String,
//    val style: String
//
//)


// Get footer Data
@Serializable
data class PromptsResponse(
    val success: Boolean,
    val message: String,
    val data: PromptData
)

@Serializable
data class PromptData(
    val prompts: CategoryList
)

@Serializable
data class CategoryList(
    val categories: List<CategoryData>
)

@Serializable
data class CategoryData(
    val name: String,
    val category_id: String,
    val effects: List<Item>
)


@Serializable
data class Item(
    val name: String,
    val prompt: String,
    val gender: String,
    val output_image: String? = null,
    val effect_id: String,
    val style: String? =null

)



//Register User
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


// Generate Image Responce
@Serializable
data class ImageResponse(
    val success: Boolean,
    val message: String,
    val data: GenerateImageResponse
)

@Serializable
data class GenerateImageResponse(
    @SerialName("image_url") val image_url: String?
)
