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
//
@Serializable
data class CategoryData(
    val name: String,
    val effects: List<Item>
)


@Serializable
data class Item(
    val effect_id: String,
    val name: String,
    @SerialName("output_image")val output_image: String? = null
)



