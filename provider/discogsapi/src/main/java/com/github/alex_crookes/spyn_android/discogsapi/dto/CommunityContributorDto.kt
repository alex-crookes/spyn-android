package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CommunityContributorDto(
    @SerialName("username") val userName: String,
    @SerialName("resource_url") val resourceUrl: String
)
