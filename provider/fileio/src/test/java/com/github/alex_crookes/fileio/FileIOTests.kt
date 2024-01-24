package com.github.alex_crookes.fileio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.junit.Test

import org.junit.Assert.*

/**
 * Tests for File IO
 */
class FileIOTests {

    private val fileIo: FileIO = AndroidFileIO()
    @Test
    fun test_MissingFileReturnsNull() {
        val sut = fileIo.readFileFromResources("/does_not_exist.nope")
        assertNull(sut)
    }
    @Test
    fun test_ResourcesCanBeRead() {
        val sut =fileIo.readFileFromResources("/test.txt")
        assertNotNull(sut)
    }

    @Test
    fun test_DeserializeSimplestClass() {
        val sut = fileIo.readClassFromResources( "/test.json", TestSimpleJson.serializer())

        assertNotNull(sut)
        assertEquals("Hello", sut?.title)
    }

    @Serializable
    private data class TestSimpleJson(
        @SerialName("title") val title: String
    )
}
