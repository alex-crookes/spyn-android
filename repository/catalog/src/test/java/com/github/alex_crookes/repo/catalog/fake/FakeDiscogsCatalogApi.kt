package com.github.alex_crookes.repo.catalog.fake

import com.github.alex_crookes.fileio.AndroidFileIO
import com.github.alex_crookes.spyn_android.discogsapi.CatalogApi
import com.github.alex_crookes.spyn_android.discogsapi.response.CollectionResponse
import java.io.FileNotFoundException

class FakeDiscogsCatalogApi: CatalogApi {
    override var authToken: String? = null

    private val resources = AndroidFileIO()

    override suspend fun collectionForUser(
        username: String, page: Int, folder: Int
    ): CollectionResponse {


        return when (page) {
            1 ->
                resources.readClassFromResources(
                    "/responses/collection_page1.results.json",
                    CollectionResponse.serializer()
                ) ?: throw FileNotFoundException("no test file")

            else -> throw Exception("Page $page not yet implemented")
        }
    }
}