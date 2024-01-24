package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto
import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationUrlsDto
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class PaginationTests: DeserializeTests() {
    private val paginationUrlsFile = "/pagination_urls.dto.json"
    private val paginationFile = "/pagination.dto.json"
    

    @Test
    fun test_PaginationUrlsDecode() {
        loadAndDeserialize(paginationUrlsFile, PaginationUrlsDto.serializer()) { sut ->
            assertNotNull(sut)
            assertNotNull(sut.next)
            assertNotNull(sut.last)    
        }
    }

    @Test
    fun test_Pagination() {
        loadAndDeserialize(paginationFile, PaginationDto.serializer()) { sut ->
            assertNotNull(sut)
            assertNotNull(sut.paginationUrls.next)
            assertNotNull(sut.paginationUrls.last)

            assertEquals(1, sut.page)
            assertEquals(200, sut.pages)
            assertEquals(50, sut.pageSize)
            assertEquals(29176, sut.totalItems)    
        }
    }
}