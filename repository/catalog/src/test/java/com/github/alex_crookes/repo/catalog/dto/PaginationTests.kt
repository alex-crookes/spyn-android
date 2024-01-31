package com.github.alex_crookes.repo.catalog.dto

import com.github.alex_crookes.repo.catalog.DeserializeTests
import com.github.alex_crookes.repo.catalog.extensions.asEntity
import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto
import org.junit.Assert.assertEquals
import org.junit.Test

class PaginationTests : DeserializeTests() {

    @Test
    fun test_PaginationStartDtoConversion() {
        loadAndDeserialize("/dto/pagination_start.dto.json", PaginationDto.serializer()) {
            val sut = it.asEntity
            assertEquals(it.page, sut.page)
            assertEquals(it.pages, sut.totalPages)
            assertEquals(it.pageSize, sut.itemsPerPage)
            assertEquals(it.totalItems, sut.totalItems)
        }
    }

    @Test
    fun test_PaginationMiddleDtoConversion() {
        loadAndDeserialize("/dto/pagination_middle.dto.json", PaginationDto.serializer()) {
            val sut = it.asEntity
            assertEquals(it.page, sut.page)
            assertEquals(it.pages, sut.totalPages)
            assertEquals(it.pageSize, sut.itemsPerPage)
            assertEquals(it.totalItems, sut.totalItems)
        }
    }

    @Test
    fun test_PaginationEndDtoConversion() {
        loadAndDeserialize("/dto/pagination_ends.dto.json", PaginationDto.serializer()) {
            val sut = it.asEntity
            assertEquals(it.page, sut.page)
            assertEquals(it.pages, sut.totalPages)
            assertEquals(it.pageSize, sut.itemsPerPage)
            assertEquals(it.totalItems, sut.totalItems)
        }
    }
}