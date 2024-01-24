package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityRatingDto(
    @SerialName("count") val ratingCount: Int,
    @SerialName("average") val averageRating: Double
)
