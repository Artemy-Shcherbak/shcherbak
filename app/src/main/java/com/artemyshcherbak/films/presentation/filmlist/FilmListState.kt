package com.artemyshcherbak.films.presentation.filmlist

import com.artemyshcherbak.films.domain.model.Film

data class FilmListState(
    val isLoading: Boolean = false,
    val films: List<Film> = listOf(),
)
