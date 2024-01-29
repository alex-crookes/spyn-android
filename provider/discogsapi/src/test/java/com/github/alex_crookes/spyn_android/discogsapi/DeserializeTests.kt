package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.fileio.AndroidFileIO
import com.github.alex_crookes.fileio.FileIO
import kotlinx.serialization.KSerializer
import org.junit.Assert.assertNotNull

abstract class DeserializeTests {
    private val fileIO: FileIO = AndroidFileIO()

    fun <T : Any> loadAndDeserialize(fileName: String, deserializer: KSerializer<T>, moreTests: ((T) -> Unit)) {
        val dto = fileIO.readClassFromResources(fileName, deserializer)

        val sut = dto ?: throw Exception("Expected not to be null")
        moreTests(sut)
    }
}
