package com.artemyshcherbak.films.data.network.datasource

import com.artemyshcherbak.films.core.common.AppDispatchers
import com.artemyshcherbak.films.core.common.Dispatcher
import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.data.network.isSuccessful
import com.artemyshcherbak.films.data.network.ktor.AppBaseUrl
import com.artemyshcherbak.films.data.network.model.getfilminfo.FilmInfoResponse
import com.artemyshcherbak.films.data.network.model.getfilms.FilmResponse
import com.artemyshcherbak.films.data.network.model.getfilms.GetFilmsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsKtorDataSource @Inject constructor(
    private val httpClient: HttpClient,
    @AppBaseUrl private val baseUrl: String,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : FilmsNetworkDataSource {

    override fun getFilms(): Flow<Result<List<FilmResponse>>> = flow {
        emit(Result.Loading)

        try {
            val httpResponse = httpClient.get("$baseUrl/api/v2.2/films/top") {
                header("x-api-key", "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
                parameter("type", "TOP_100_POPULAR_FILMS")
            }

            val responseBody = httpResponse.body<GetFilmsResponse>()

            if (httpResponse.isSuccessful) {
                emit(Result.Success(responseBody.films.orEmpty()))
            } else {
                emit(Result.Error(Exception("Something went wrong")))
            }
        } catch (e: Throwable) {
            emit(Result.Error(e))
        }
    }.flowOn(ioDispatcher)

    override fun getFilmInfo(filmId: Long): Flow<Result<FilmInfoResponse>> = flow {
        emit(Result.Loading)

        try {
            val httpResponse = httpClient.get("$baseUrl/api/v2.2/films/$filmId") {
                header("x-api-key", "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
            }

            val responseBody = httpResponse.body<FilmInfoResponse>()

            if (httpResponse.isSuccessful) {
                emit(Result.Success(responseBody))
            } else {
                emit(Result.Error(Exception("Something went wrong")))
            }
        } catch (e: Throwable) {
            emit(Result.Error(e))
        }
    }.flowOn(ioDispatcher)
}
