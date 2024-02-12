package com.artemyshcherbak.films.data.repository

import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.domain.model.Film
import com.artemyshcherbak.films.domain.model.FilmInfo
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {

    fun getFilms(): Flow<Result<List<Film>>>

    fun getFilmInfo(filmId: Long): Flow<Result<FilmInfo>>
}
