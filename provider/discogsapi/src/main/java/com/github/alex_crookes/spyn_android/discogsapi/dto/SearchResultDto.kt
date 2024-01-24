package com.github.alex_crookes.spyn_android.discogsapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResultDto(
    @SerialName("country") val country: String,
    @SerialName("year") val year: String,
    @SerialName("format") val formats: List<String>,
    @SerialName("label") val labels: List<String>,
    @SerialName("type") val type: String,
    @SerialName("genre") val genres: List<String>,
    @SerialName("style") val styles: List<String>,
    @SerialName("master_id") val masterId: Long,
    @SerialName("id") val id: Long,
    @SerialName("barcode") val barcodes: List<String>,
    @SerialName("master_url") val masterUrl: String,
    @SerialName("uri") val relativeUrl: String,
    @SerialName("catno") val catalogNumber: String,
    @SerialName("title") val title: String,
    @SerialName("thumb") val thumbnailImage: String,
    @SerialName("cover_image") val coverImage: String,
    @SerialName("resource_url") val resourceUrl: String,
    @SerialName("user_data") val userStatus: UserStatusDto,
    @SerialName("community") val communityStatus: CommunityReleaseStatusDto
)
