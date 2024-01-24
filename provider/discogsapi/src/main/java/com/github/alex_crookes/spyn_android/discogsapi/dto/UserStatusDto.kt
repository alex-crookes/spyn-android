package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class UserStatusDto(
    @SerialName("in_wantlist") val wanted: Boolean,
    @SerialName("in_collection") val owned: Boolean
)
