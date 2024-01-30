package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReleaseIdentifierDto(
    @SerialName("type") val type: String,
    @SerialName("value") val value: String,
    @SerialName("description") val description: String,
)
