package com.github.alex_crookes.repo.catalog

import com.github.alex_crookes.repo.catalog.entity.CollectionPage
import com.github.alex_crookes.repo.catalog.extensions.asEntity
import com.github.alex_crookes.spyn_android.discogsapi.CatalogApi

class DiscogsCatalogRepository(private val api: CatalogApi) : CatalogRepository {

    // region Implementations

    override suspend fun getCollectionFor(
        username: String, page: Int, folder: Int
    ): CollectionPage {
        val response = api.collectionForUser(username, page, folder)

        return CollectionPage(
            userName = username,
            folder = folder,
            pagination = response.pagination.asEntity,
            items = response.releases.map { it.asEntity }
        )
    }

    // endregion

}