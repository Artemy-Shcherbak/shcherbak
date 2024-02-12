package com.artemyshcherbak.films.presentation.filmlist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

const val FILM_IMAGE_BOX_HEIGHT = 260

@Composable
fun FilmImage(url: String, contentDescription: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(coil.size.Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(FILM_IMAGE_BOX_HEIGHT.dp),
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .fillMaxSize()
                )
            }

            is AsyncImagePainter.State.Success, AsyncImagePainter.State.Empty -> {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            is AsyncImagePainter.State.Error -> {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.error)
                        .fillMaxSize()
                )
            }
        }
    }
}
