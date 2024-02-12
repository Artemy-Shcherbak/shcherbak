package com.artemyshcherbak.films.presentation.filminfo

sealed class FilmInfoEvent {

    data class GetFilmInfo(val filmId: Long) : FilmInfoEvent()
}
