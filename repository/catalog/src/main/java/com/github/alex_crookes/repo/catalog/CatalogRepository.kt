package com.github.alex_crookes.repo.catalog

import com.github.alex_crookes.repo.catalog.entity.CollectionPage

interface CatalogRepository{
    suspend fun getCollectionFor(username: String, page: Int = 1, folder: Int = 1): CollectionPage
}