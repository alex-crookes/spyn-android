package com.github.alex_crookes.repo.catalog.entity

import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto

data class Pagination(
    val page: Int,
    val totalPages: Int,
    val itemsPerPage: Int,
    val totalItems: Int
)
