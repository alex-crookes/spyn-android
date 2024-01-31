package com.github.alex_crookes.repo.catalog.extensions

import com.github.alex_crookes.repo.catalog.entity.Pagination
import com.github.alex_crookes.spyn_android.discogsapi.dto.PaginationDto

internal val PaginationDto.asEntity: Pagination
    get() = Pagination(
        page = this.page,
        totalItems = this.totalItems,
        totalPages = this.pages,
        itemsPerPage = this.pageSize
    )
