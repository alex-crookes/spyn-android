package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.spyn_android.discogsapi.response.CollectionResponse

/**
 * The CatalogApi provided access to information about Releases and Collections of Releases
 */
interface CatalogApi {

    var authToken: String?

    /**
     * CollectionForUser returns the data about the Users collection of releases
     *
     * @param username Username for which to return the collection
     * @param page the collection is Paginated (see below) and defaults to (and starts at) 1
     *      - Page may not exceed the total number of pages
     * @param folder the user can organize their media into folder - the default is 1
     *
     * @return Collection Response
     *
     * @see com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto
     */
    suspend fun collectionForUser(
        username: String, page: Int = 1, folder: Int = 1
    ): CollectionResponse

//    suspend fun getReleaseByCatalogNumber(catalogNumber: String)

//    suspend fun getArtist(artistId: Long): ArtistDto
}
