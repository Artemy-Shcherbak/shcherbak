package com.artemyshcherbak.films.presentation.filmlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemyshcherbak.films.core.common.Result
import com.artemyshcherbak.films.domain.usecases.GetFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val getFilmsUseCase: GetFilmsUseCase,
) : ViewModel() {

    val state: MutableState<FilmListState> = mutableStateOf(FilmListState())

    init {
        onTriggerEvent(FilmListEvent.GetFilms)
    }

    fun onTriggerEvent(event: FilmListEvent) {
        when (event) {
            is FilmListEvent.GetFilms -> getFilms()
        }
    }

    private fun getFilms() {
        getFilmsUseCase().onEach {
            state.value = state.value.copy(isLoading = it is Result.Loading)
            when (it) {
                is Result.Error -> {}
                Result.Loading -> {}
                is Result.Success -> state.value = state.value.copy(films = it.data)
            }
        }.launchIn(viewModelScope)
    }
}
