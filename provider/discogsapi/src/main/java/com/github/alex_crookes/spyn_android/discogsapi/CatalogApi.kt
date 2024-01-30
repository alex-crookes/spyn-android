package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.response.CollectionResponse

/**
 * The CatalogApi provided access to information about Releases and Collections of Releases
 */
interface CatalogApi {

    var authToken: String?

    suspend fun collectionForUser(
        username: String, page: Int = 0, folder: Int = 1
    ): CollectionResponse

//    suspend fun getReleaseByCatalogNumber(catalogNumber: String)

//    suspend fun getArtist(artistId: Long): ArtistDto
}
