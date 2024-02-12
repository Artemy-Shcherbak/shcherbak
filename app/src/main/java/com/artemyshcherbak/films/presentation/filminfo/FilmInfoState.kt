package com.artemyshcherbak.films.presentation.filminfo

import com.artemyshcherbak.films.domain.model.FilmInfo

data class FilmInfoState(
    val isLoading: Boolean = false,
    val filmInfo: FilmInfo? = null,
)
