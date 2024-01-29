package com.github.alex_crookes.spyn_android.discogsapi.response

import com.github.alex_crookes.spyn_android.discogsapi.dto.CollectionReleaseDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionResponse(
    @SerialName("pagination") val pagination: PaginationDto,
    @SerialName("releases") val releases: List<CollectionReleaseDto>
)
