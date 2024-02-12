package com.artemyshcherbak.films.presentation

object FilmDestination {
    internal const val filmIdArg = "searchId"
    val route = "film_route?$filmIdArg={$filmIdArg}"
    val destination = "search_destination"

    fun createNavigationRoute(filmId: Long): String = "film_route?$filmIdArg=$filmIdArg"
}
