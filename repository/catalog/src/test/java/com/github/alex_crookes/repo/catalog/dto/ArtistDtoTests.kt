package com.github.alex_crookes.repo.catalog.dto

import com.github.alex_crookes.repo.catalog.DeserializeTests
import com.github.alex_crookes.repo.catalog.extensions.asEntity
import com.github.alex_crookes.spyn_android.discogsapi.dto.ArtistDto
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtistDtoTests : DeserializeTests() {

    @Test
    fun test_ArtistDto() {
        loadAndDeserialize("/dto/artist.dto.json", ArtistDto.serializer()) {
            val sut = it.asEntity

            assertEquals(it.name, sut.name)
            assertEquals(it.id, sut.id)
            assertEquals(it.thumbnail, sut.image)
        }
    }

}