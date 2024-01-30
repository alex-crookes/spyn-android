package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommunityReleaseStatusDto(
    @SerialName("want") val wantedBy: Long,
    @SerialName("have") val ownedBy: Long
)
