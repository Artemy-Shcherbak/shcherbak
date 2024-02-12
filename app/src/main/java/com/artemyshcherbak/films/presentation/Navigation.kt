package com.artemyshcherbak.films.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.artemyshcherbak.films.core.common.FILM_ID_ARG
import com.artemyshcherbak.films.presentation.filminfo.FilmInfoScreen
import com.artemyshcherbak.films.presentation.filminfo.FilmInfoViewModel
import com.artemyshcherbak.films.presentation.filmlist.FilmListScreen
import com.artemyshcherbak.films.presentation.filmlist.FilmListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FilmList.route) {
        composable(
            route = Screen.FilmList.route
        ) {
            val viewModel = hiltViewModel<FilmListViewModel>()
            FilmListScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent,
                onClickFilmListItem = { filmId ->
                    navController.navigate(Screen.FilmDetail.route + "/$filmId")
                }
            )
        }
        composable(
            route = Screen.FilmDetail.route + "/{$FILM_ID_ARG}",
            arguments = listOf(navArgument(FILM_ID_ARG) {
                type = NavType.IntType
            })
        ) {
            val viewModel = hiltViewModel<FilmInfoViewModel>()
            FilmInfoScreen(
                state = viewModel.state.value,
                onTriggerEvent = viewModel::onTriggerEvent
            )
        }
    }
}
