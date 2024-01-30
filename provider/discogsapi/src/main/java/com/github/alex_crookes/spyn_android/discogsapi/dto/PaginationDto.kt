package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationDto(
    @SerialName("page") val page: Int,
    @SerialName("pages") val pages: Int,
    @SerialName("per_page") val pageSize: Int,
    @SerialName("items") val totalItems: Int,
    @SerialName("urls") val paginationUrls: PaginationUrlsDto
)
