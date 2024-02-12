package com.artemyshcherbak.films.presentation.filminfo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemyshcherbak.films.presentation.filminfo.components.FilmInfoCard
import com.artemyshcherbak.films.presentation.filminfo.components.LoadingFilmShimmer
import com.artemyshcherbak.films.presentation.filmlist.components.FILM_IMAGE_BOX_HEIGHT

@Composable
fun FilmInfoScreen(
    state: FilmInfoState,
    onTriggerEvent: (FilmInfoEvent) -> Unit,
) {
    when {
        state.filmInfo == null && state.isLoading -> {
            LoadingFilmShimmer(imageHeight = FILM_IMAGE_BOX_HEIGHT.dp)
        }

        state.filmInfo == null && !state.isLoading -> {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "We were unable to retrieve the details for this film.\nTry resetting the app.",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        else -> {
            state.filmInfo?.let {
                FilmInfoCard(
                    filmInfo = state.filmInfo
                )
            }
        }
    }
}
