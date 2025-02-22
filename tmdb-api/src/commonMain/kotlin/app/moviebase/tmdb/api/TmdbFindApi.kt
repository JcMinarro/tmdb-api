package app.moviebase.tmdb.api

import app.moviebase.tmdb.remote.endPointV3
import app.moviebase.tmdb.remote.parameterLanguage
import app.moviebase.tmdb.model.TmdbExternalSource
import app.moviebase.tmdb.model.TmdbFindResults
import io.ktor.client.*
import io.ktor.client.request.*

class TmdbFindApi internal constructor(private val client: HttpClient) {

    suspend fun find(externalId: String, language: String, externalSource: TmdbExternalSource): TmdbFindResults = client.get {
        endPointV3("find", externalId)

        parameterLanguage(language)
        parameter("external_source", externalSource.value)
    }
}
