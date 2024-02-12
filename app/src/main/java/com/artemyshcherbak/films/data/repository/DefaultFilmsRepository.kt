package com.artemyshcherbak.films.data.repository

import com.artemyshcherbak.films.core.common.AppDispatchers
import com.artemyshcherbak.films.core.common.Dispatcher
import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.core.common.mapResult
import com.artemyshcherbak.films.data.network.datasource.FilmsNetworkDataSource
import com.artemyshcherbak.films.data.network.mappers.asExternalModel
import com.artemyshcherbak.films.data.network.mappers.asExternalModelList
import com.artemyshcherbak.films.domain.model.Film
import com.artemyshcherbak.films.domain.model.FilmInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultFilmsRepository @Inject constructor(
    private val filmsNetworkDataSource: FilmsNetworkDataSource,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : FilmsRepository {

    override fun getFilms(): Flow<Result<List<Film>>> = filmsNetworkDataSource
        .getFilms()
        .mapResult { it.asExternalModelList() }
        .flowOn(ioDispatcher)

    override fun getFilmInfo(filmId: Long): Flow<Result<FilmInfo>> = filmsNetworkDataSource
        .getFilmInfo(filmId)
        .mapResult { it.asExternalModel() }
        .flowOn(ioDispatcher)
}
