package com.github.alex_crookes.repo.catalog.dto

import com.github.alex_crookes.repo.catalog.DeserializeTests
import com.github.alex_crookes.repo.catalog.extensions.asEntity
import com.github.alex_crookes.spyn_android.discogsapi.dto.CollectionReleaseDto
import com.github.alex_crookes.spyn_android.discogsapi.response.CollectionResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CollectionReleaseDtoTests : DeserializeTests() {

    @Test
    fun test_singleDto() {
        loadAndDeserialize(
            "/dto/collection_release.dto.json", CollectionReleaseDto.serializer()
        ) {
            assertNotNull(it)
            val sut = it.asEntity

            assertEquals(it.id, sut.id)
            assertEquals(it.instanceId, sut.instanceId)
            assertNotNull(sut.toString(), sut.dateAdded)
            assertTrue(sut.dateAdded > 0)
            assertEquals(it.rating, sut.rating, 0.0)
            assertEquals(it.basicInformation.masterId, sut.masterReleaseId)
            assertEquals(it.basicInformation.coverImage, sut.coverImage)
            assertEquals(it.basicInformation.thumbnail, sut.thumbnailImage)
            assertEquals(it.basicInformation.year, sut.year)
            assertEquals(it.basicInformation.artists.size, sut.artists.size)
            assertEquals(it.basicInformation.artists.first().name, sut.artists.first().name)
            assertEquals(it.basicInformation.genres.size, sut.genres.size)
            assertEquals(it.folder, sut.folder)
        }
    }

    @Test
    fun test_Response() {
        loadAndDeserialize(
            "/responses/collection_page1.results.json", CollectionResponse.serializer()
        ) { response ->
            assertNotNull(response)
            assertNotNull(response.pagination)
            assertNotNull(response.releases)

            val paginationSut = response.pagination.asEntity
            assertEquals(1, paginationSut.page)
            assertEquals(3, paginationSut.totalPages)
            assertEquals(50, paginationSut.itemsPerPage)
            assertEquals(117, paginationSut.totalItems)


            response.releases.forEach {
                val sut = it.asEntity

                assertEquals(it.id, sut.id)
                assertEquals(it.instanceId, sut.instanceId)
                assertNotNull(sut.toString(), sut.dateAdded)
                assertTrue(sut.dateAdded > 0)
                assertEquals(it.rating, sut.rating, 0.0)
                assertEquals(it.basicInformation.masterId, sut.masterReleaseId)
                assertEquals(it.basicInformation.coverImage, sut.coverImage)
                assertEquals(it.basicInformation.thumbnail, sut.thumbnailImage)
                assertEquals(it.basicInformation.year, sut.year)
                assertEquals(it.basicInformation.artists.size, sut.artists.size)
                assertEquals(it.basicInformation.artists.first().name, sut.artists.first().name)
                assertEquals(it.basicInformation.genres.size, sut.genres.size)
                assertEquals(it.folder, sut.folder)
            }
        }
    }
}