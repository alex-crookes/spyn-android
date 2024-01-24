package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.dto.CollectionBasicReleaseInformationDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.CollectionReleaseDto
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CollectionTests : DeserializeTests() {
    private val basicInformation = "/collection_release_basic_information.dto.json"
    private val collectionRelease = "/collection_release.dto.json"
    @Test
    fun test_BasicInformationDtoDeserialized() {
        loadAndDeserialize(
            basicInformation, CollectionBasicReleaseInformationDto.serializer()
        ) { sut ->
            assertEquals(460238, sut.id)
            assertTrue(sut.resourceUrl.contains(sut.id.toString()))
            assertEquals(4322, sut.masterId)
            assertTrue(sut.masterUrl.contains(sut.masterId.toString()))
            assertNotNull(sut.thumbnail)
            assertNotNull(sut.coverImage)
            assertEquals("Tales Of Mystery And Imagination", sut.title)
            assertEquals(1976, sut.year)
            assertEquals(1, sut.formats.size)
            assertEquals("Vinyl", sut.formats.first().name)
            assertEquals(1, sut.artists.size)
            assertEquals("The Alan Parsons Project", sut.artists.first().name)
            assertEquals(1, sut.labels.size)
            assertEquals("6370 243", sut.labels.first().catalogueNumber)
            assertEquals(1, sut.genres.size)
            assertEquals(3, sut.styles.size)
            assertEquals("Prog Rock", sut.styles.last())
        }
    }

    @Test
    fun test_CollectionReleaseDtoDeserialized() {
        loadAndDeserialize(collectionRelease, CollectionReleaseDto.serializer()) { sut ->
            assertEquals(27888312, sut.id)
            assertTrue(sut.date.contains("2024"))
            assertEquals(1561681507, sut.instanceId)
            assertEquals(0.0, sut.rating, 0.0)
            assertNotNull(sut.basicInformation)
            assertEquals("Treasure", sut.basicInformation.title)
            assertEquals("Cocteau Twins", sut.basicInformation.artists.first().name)
            assertEquals(1, sut.basicInformation.styles.size)
            assertEquals(1, sut.folder)
        }
    }
}
