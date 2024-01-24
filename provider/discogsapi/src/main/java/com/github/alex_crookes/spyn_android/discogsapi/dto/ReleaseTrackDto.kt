package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ReleaseTrackDto(
    @SerialName("position") val position: String,
    @SerialName("type_") val type: String,
    @SerialName("title") val title: String,
    @SerialName("extraartists") val extraArtists: List<ArtistDto>,
    @SerialName("duration") val duration: String
)
