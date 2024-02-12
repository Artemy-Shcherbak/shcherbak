package com.artemyshcherbak.films.data.network.datasource

import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.data.network.model.getfilminfo.FilmInfoResponse
import com.artemyshcherbak.films.data.network.model.getfilms.FilmResponse
import kotlinx.coroutines.flow.Flow

interface FilmsNetworkDataSource {

    fun getFilms(): Flow<Result<List<FilmResponse>>>

    fun getFilmInfo(filmId: Long): Flow<Result<FilmInfoResponse>>
}
