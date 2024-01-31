package com.github.alex_crookes.repo.catalog.entity

import com.github.alex_crookes.spyn_android.discogsapi.dto.ArtistDto

data class Artist(
    val name: String,
    val id: Long,
    val image: String?
)


