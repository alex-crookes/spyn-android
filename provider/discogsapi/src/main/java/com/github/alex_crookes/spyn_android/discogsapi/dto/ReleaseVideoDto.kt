package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReleaseVideoDto(
    @SerialName("uri") val url: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("duration") val duration: Int,
    @SerialName("embed") val embed: Boolean
)
