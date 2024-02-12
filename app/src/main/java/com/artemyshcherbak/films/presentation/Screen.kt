package com.artemyshcherbak.films.presentation

sealed class Screen(val route: String) {

    data object FilmList : Screen("filmList")

    data object FilmDetail : Screen("filmDetail")
}
