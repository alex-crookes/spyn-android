package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationUrlsDto(
    @SerialName("first") val first: String? = null,
    @SerialName("last") val last: String? = null,
    @SerialName("prev") val previous: String? = null,
    @SerialName("next") val next: String? = null,
)
