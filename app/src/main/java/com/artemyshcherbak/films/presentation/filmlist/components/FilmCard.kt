package com.artemyshcherbak.films.presentation.filmlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemyshcherbak.films.domain.model.Film

@Composable
fun FilmCard(
    film: Film,
    onClick: () -> Unit = {}
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation()
    ) {
        val genresStr = remember {
            film.genres.joinToString(separator = ", ")
        }
        Column {
            FilmImage(url = film.posterUrl, contentDescription = film.nameRu)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = film.nameRu + " (" + genresStr + ")",
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.85f)
                        .wrapContentWidth(align = Alignment.Start),
                )
                Text(
                    text = film.year,
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.85f)
                        .wrapContentWidth(align = Alignment.End)
                        .align(alignment = Alignment.CenterVertically),
                )
            }
        }
    }
}
