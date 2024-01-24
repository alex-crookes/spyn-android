package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EntityDto(
    @SerialName("entity_type") val type: String,
    @SerialName("entity_type_name") val typeName: String,
    @SerialName("name") val name: String,
    @SerialName("catno") val catalogueNumber: String? = "",
    @SerialName("id") val id: Long,
    @SerialName("resource_url") val resourceUrl: String
)
