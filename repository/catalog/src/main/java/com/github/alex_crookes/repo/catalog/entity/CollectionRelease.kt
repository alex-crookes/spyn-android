package com.github.alex_crookes.repo.catalog.entity

import android.media.Rating

data class CollectionRelease(
    val id: Long,
    val instanceId: Long,
    val dateAdded: Long,
    val rating: Double,

    val masterReleaseId: Long,
    val coverImage: String?,
    val thumbnailImage: String,

    val year: Int,

    val artists: List<Artist>,

    val genres: List<String>,
    val folder: Int? = 1,

)
