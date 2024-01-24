package com.github.alex_crookes.fileio

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class AndroidFileIO: FileIO {

    // region Implementations
    override fun readFileFromResources(filename: String): String? = getFile(filename)

    override fun <T : Any> readClassFromResources(
        filename: String, deserializer: KSerializer<T>
    ): T? {

        val fileContents = getFile(filename) ?: return null

        return Json.decodeFromString(deserializer, fileContents)
    }

    // endregion


    // region Helpers
    private fun getFile(filename: String): String? {
        javaClass.getResourceAsStream(filename)?.let { stream ->
            val stringValue = stream.bufferedReader().use { it.readText() }
            stream.close()
            return stringValue
        }

        return null
    }

    // endregion

}


interface FileIO {
    fun readFileFromResources(filename: String): String?

    fun <T : Any> readClassFromResources(filename: String, deserializer: KSerializer<T>): T?
}
