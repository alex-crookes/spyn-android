package com.github.alex_crookes.spyn_android.discogsapi.response

import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.SearchResultDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("pagination") val pagination: PaginationDto,
    @SerialName("results") val results: List<SearchResultDto>
)

