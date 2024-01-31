package com.github.alex_crookes.repo.catalog.extensions

import com.github.alex_crookes.repo.catalog.entity.Artist
import com.github.alex_crookes.spyn_android.discogsapi.dto.ArtistDto

internal val ArtistDto.asEntity: Artist
    get() = Artist(
        name = this.name,
        id = this.id,
        image =  this.thumbnail
    )
