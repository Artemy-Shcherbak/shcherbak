package com.artemyshcherbak.films.domain.usecases

import com.artemyshcherbak.films.core.common.AppDispatchers
import com.artemyshcherbak.films.core.common.Dispatcher
import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.data.repository.FilmsRepository
import com.artemyshcherbak.films.domain.model.FilmInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetFilmInfoUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(filmId: Long): Flow<Result<FilmInfo>> =
        filmsRepository.getFilmInfo(filmId)
            .catch { e -> emit(Result.Error(e)) }
            .flowOn(ioDispatcher)
}
