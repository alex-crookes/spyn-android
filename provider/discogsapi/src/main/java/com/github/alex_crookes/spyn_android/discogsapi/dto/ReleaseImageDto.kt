package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReleaseImageDto(
    @SerialName("type") val type: String,
    @SerialName("uri") val masterImage: String,
    @SerialName("resource_url") val otherMasterImage: String, // note: seems to be a copy of MasterImage
    @SerialName("uri150") val thumbnail: String,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int
)
