package com.eramlab.behrupiya.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    val category: String,
    val items: List<Item>
)

@Serializable
data class Item(
    val id: Int,
    val title: String,
    val imageUrl: String,
)

