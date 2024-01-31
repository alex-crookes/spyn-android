package com.github.alex_crookes.repo.catalog.extensions

import com.github.alex_crookes.repo.catalog.entity.CollectionRelease
import com.github.alex_crookes.spyn_android.discogsapi.dto.CollectionReleaseDto
import java.time.Instant

internal val CollectionReleaseDto.asEntity: CollectionRelease
    get() {
        val addedOn = Instant.parse(this.date).toEpochMilli()

        return CollectionRelease(
            id = this.id,
            instanceId = this.instanceId,
            dateAdded = addedOn,
            rating = this.rating,
            masterReleaseId = this.basicInformation.masterId,
            coverImage = this.basicInformation.coverImage,
            thumbnailImage = this.basicInformation.thumbnail,
            year = this.basicInformation.year,
            artists = this.basicInformation.artists.map { it.asEntity },
            genres = this.basicInformation.genres,
            folder = this.folder
        )
    }
