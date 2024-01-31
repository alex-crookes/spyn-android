package com.github.alex_crookes.spyn_android.discogsapi

import com.github.alex_crookes.preferences.Preferences
import com.github.alex_crookes.spyn_android.discogsapi.response.CollectionResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DiscogsCatalogApi(private val preferences: Preferences) : CatalogApi {

    // region Properties
    private val authTokenPluginName = "DiscogsTokenAuthPlugin"
    private val rootPath = "https://api.discogs.com"
    private val pageSize = 50


    private var httpClient: HttpClient? = null

    private val jsonBuilder = Json {
        prettyPrint = false
        isLenient = false
        ignoreUnknownKeys = false
    }

    // endregion


    // region Implementations

    override var authToken: String?
        get() = preferences.getString(PreferenceKeys.AUTH_TOKEN)
        set(new) {
            new?.let {
                preferences.putString(PreferenceKeys.AUTH_TOKEN, it)
                val authPlugin = createClientPlugin(authTokenPluginName) {
                    val authHeaderKey = "Authorization"
                    //val headerValue = "Discogs token=${new}"
                    val authHeaderValue = "Discogs token=$new"
                    val userAgentHeader = "User-Agent"
                    val userAgentValue = "SPYN 1.0"
                    onRequest { request, _ ->
                        request.headers.append(authHeaderKey, authHeaderValue)
                        request.headers.append(userAgentHeader, userAgentValue)
                    }
                }
                httpClient = HttpClient {
                    install(ContentNegotiation) { json(jsonBuilder) }
                    install(authPlugin)
                }
            } ?: run {
                preferences.remove(PreferenceKeys.AUTH_TOKEN)
                httpClient = null
            }
        }

    override suspend fun collectionForUser(
        username: String, page: Int, folder: Int
    ): CollectionResponse {
        val client = httpClient ?: throw CatalogError.AuthenticationRequired("Missing Auth Token")

        val path = "$rootPath/users/$username/collection/folders/$folder/releases?page=$page" +
                "&pageSize=$pageSize"
        val url = URLBuilder(path).build()
        return client.get(url).body<CollectionResponse>()
    }

    // endregion


    // region Helpers


    // endregion


}

internal object PreferenceKeys {
    const val AUTH_TOKEN = "_authToken"
}
