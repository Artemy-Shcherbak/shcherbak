package com.artemyshcherbak.films.presentation.filminfo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemyshcherbak.films.domain.model.FilmInfo
import com.artemyshcherbak.films.presentation.filmlist.components.FilmImage

@Composable
fun FilmInfoCard(
    filmInfo: FilmInfo,
    onClick: () -> Unit = {}
) {
    val countriesStr = remember {
        filmInfo.countries.joinToString(separator = ", ")
    }
    val genresStr = remember {
        filmInfo.genres.joinToString(separator = ", ")
    }
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, bottom = 6.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation()
    ) {
        Column {
            FilmImage(url = filmInfo.posterUrl, contentDescription = filmInfo.nameRu)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = filmInfo.nameRu)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = filmInfo.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = countriesStr)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = genresStr)
        }
    }
}
