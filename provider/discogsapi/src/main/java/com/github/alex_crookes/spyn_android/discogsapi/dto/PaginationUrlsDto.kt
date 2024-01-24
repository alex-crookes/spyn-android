package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationUrlsDto(
    @SerialName("last") val last: String,
    @SerialName("next") val next: String,
)
