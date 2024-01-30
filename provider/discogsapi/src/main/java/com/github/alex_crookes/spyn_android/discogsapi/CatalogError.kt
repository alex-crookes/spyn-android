package com.github.alex_crookes.spyn_android.discogsapi


sealed class CatalogError(message: String) : Error(message) {
    data class AuthenticationRequired(override val message: String): CatalogError(message)

}

