package com.github.alex_crookes.repo.catalog.entity

data class CollectionPage(
    val userName: String,
    val folder: Int,
    val pagination: Pagination,
    val items: List<CollectionRelease>
)
