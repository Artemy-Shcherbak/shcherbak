package com.artemyshcherbak.films.presentation.filminfo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemyshcherbak.films.core.common.FILM_ID_ARG
import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.domain.usecases.GetFilmInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getFilmInfoUseCase: GetFilmInfoUseCase,
) : ViewModel() {

    private val filmId: Long = checkNotNull(savedStateHandle[FILM_ID_ARG])
    val state: MutableState<FilmInfoState> = mutableStateOf(FilmInfoState())

    init {
        onTriggerEvent(FilmInfoEvent.GetFilmInfo(filmId))
    }

    fun onTriggerEvent(event: FilmInfoEvent) {
        when (event) {
            is FilmInfoEvent.GetFilmInfo -> getFilms(event.filmId)
        }
    }

    private fun getFilms(filmId: Long) {
        getFilmInfoUseCase(filmId).onEach {
            state.value = state.value.copy(isLoading = it is Result.Loading)
            when (it) {
                is Result.Error -> {}
                Result.Loading -> {}
                is Result.Success -> state.value = state.value.copy(filmInfo = it.data)
            }
        }.launchIn(viewModelScope)
    }
}
