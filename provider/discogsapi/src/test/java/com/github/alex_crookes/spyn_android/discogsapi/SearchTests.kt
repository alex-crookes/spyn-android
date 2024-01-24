package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.dto.CommunityReleaseStatusDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.SearchResultDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.UserStatusDto
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SearchTests: DeserializeTests() {

    private val userStatusDto = "/user_status.dto.json"
    private val communityReleaseStatusDto = "/community_release_status.dto.json"
    private val searchResultDto = "/search_result.dto.json"

    @Test
    fun test_UserStatusDtoDeserialized() {
        loadAndDeserialize(userStatusDto, UserStatusDto.serializer()) { sut ->
            assertFalse(sut.owned)
            assertFalse(sut.wanted)
        }
    }

    @Test
    fun test_CommuntiyReleaseStatusDto() {
        loadAndDeserialize(communityReleaseStatusDto, CommunityReleaseStatusDto.serializer()) { sut ->
            assertEquals(41959, sut.wantedBy)
            assertEquals(89479, sut.ownedBy)
        }
    }

    @Test
    fun test_SingleSearchResultDto() {
        loadAndDeserialize(searchResultDto, SearchResultDto.serializer()) { sut ->
            assertEquals("US", sut.country)
            assertEquals(1978.toString(), sut.year)
            assertEquals(4, sut.formats.size)
            assertEquals("Stereo", sut.formats.last())
            assertEquals(15, sut.labels.size)
            assertEquals("Oversnare Music", sut.labels.last())
            assertEquals("master", sut.type)
            assertEquals(1, sut.genres.size)
            assertEquals("Rock", sut.genres.last())
            assertEquals(3, sut.styles.size)
            assertEquals("Power Pop", sut.styles.last())
            assertEquals(69666, sut.id)
            assertEquals(21, sut.barcodes.size)
            assertFalse(sut.userStatus.owned)
            assertEquals(sut.id, sut.masterId)
            assertTrue(sut.masterUrl.contains(sut.masterId.toString()))
            assertEquals("6E-135", sut.catalogNumber)
            assertEquals("The Cars - The Cars", sut.title)
            assertNotNull(sut.thumbnailImage)
            assertNotNull(sut.coverImage)
            assertEquals(41959, sut.communityStatus.wantedBy)
            assertTrue(sut.resourceUrl.contains(sut.id.toString()))
            assertTrue(sut.relativeUrl.contains(sut.id.toString()))

        }
    }
}