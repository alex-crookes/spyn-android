package com.github.alex_crookes.repo.catalog

import com.github.alex_crookes.repo.catalog.fake.FakeDiscogsCatalogApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CatalogRepositoryTests {
    private lateinit var repository: CatalogRepository

    @Before
    fun tearUp() {
        val fakeApi = FakeDiscogsCatalogApi()
        repository = DiscogsCatalogRepository(fakeApi)
    }

    @Test
    fun test_CollectionResponsePage1() {
        runTest {

            val userName = "HiFiChild"
            val folder = 1
            val sut = repository.getCollectionFor(userName, 1, folder)
            assertNotNull(sut.pagination)
            assertNotNull(sut.items)

            assertEquals(userName, sut.userName)
            assertEquals(folder, sut.folder)
            assertEquals(1, sut.pagination.page)
            assertEquals(117, sut.pagination.totalItems)
            assertEquals( 3, sut.pagination.totalPages)

            // because there is more than one page, the first page is full
            assertEquals(sut.pagination.itemsPerPage, sut.items.size)

            assertEquals(1, sut.items.last().genres.size)
        }
    }
}