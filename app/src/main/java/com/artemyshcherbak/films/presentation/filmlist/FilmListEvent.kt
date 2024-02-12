package com.artemyshcherbak.films.presentation.filmlist

sealed class FilmListEvent {

    data object GetFilms : FilmListEvent()
}
