package com.eramlab.behrupiya.data.network

import com.eramlab.behrupiya.data.model.CategoryData
import com.eramlab.behrupiya.utils.AppConstants
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class NetworkLayer {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchCategoryData(): List<CategoryData> {
        return client.get(AppConstants.JSON_DATA_ENDPOINT).body()
    }

    fun close() {
        client.close()
    }
}