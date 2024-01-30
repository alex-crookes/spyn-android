package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.fakes.FakePreferences
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CollectionApiTest {
    private val goodToken = "zNxkKRoDESfycbTLSQcHuXYhcfpocGFNpxPJIehQ"

    private lateinit var sut: CatalogApi


    @Before
    fun tearUp() {
        val prefs = FakePreferences()
        sut = DiscogsCatalogApi(prefs)
    }

    @Test
    fun test_BasicGet() {
        sut.authToken = goodToken
        runTest {

            val result = sut.collectionForUser("HiFiChild" )
            assertNotNull(result)
            assertEquals(1, result.pagination.page)
            assertEquals(50, result.pagination.pageSize)
        }
    }

    @Test
    fun test_BasicGetNextPage() {
        sut.authToken = goodToken
        runTest {

            val result = sut.collectionForUser("HiFiChild", 2 )
            assertNotNull(result)
            assertEquals(2, result.pagination.page)
            assertEquals(50, result.pagination.pageSize)
        }
    }
}
