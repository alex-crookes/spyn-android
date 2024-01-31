package com.github.alex_crookes.repo.catalog

import com.github.alex_crookes.fileio.AndroidFileIO
import com.github.alex_crookes.fileio.FileIO
import kotlinx.serialization.KSerializer

abstract class DeserializeTests {
    private val fileIO: FileIO = AndroidFileIO()

    fun <T : Any> loadAndDeserialize(fileName: String, deserializer: KSerializer<T>, moreTests: ((T) -> Unit)) {
        val dto = fileIO.readClassFromResources(fileName, deserializer)

        val sut = dto ?: throw Exception("Expected not to be null")
        moreTests(sut)
    }
}
