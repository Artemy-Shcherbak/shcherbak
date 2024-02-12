package com.artemyshcherbak.films.presentation.filmlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.artemyshcherbak.films.presentation.filmlist.components.FILM_IMAGE_BOX_HEIGHT
import com.artemyshcherbak.films.presentation.filmlist.components.FilmCard
import com.artemyshcherbak.films.presentation.filmlist.components.LoadingFilmListShimmer

@Composable
fun FilmListScreen(
    state: FilmListState,
    onTriggerEvent: (FilmListEvent) -> Unit,
    onClickFilmListItem: (Long) -> Unit
) {
    when {
        state.isLoading && state.films.isEmpty() -> LoadingFilmListShimmer(
            imageHeight = FILM_IMAGE_BOX_HEIGHT.dp
        )

        state.films.isEmpty() -> { /* Nothing to show... No films */
        }

        else -> {
            LazyColumn {
                itemsIndexed(items = state.films) { _, film ->
                    FilmCard(
                        film = film,
                        onClick = { onClickFilmListItem(film.id) }
                    )
                }
            }
        }
    }
}
