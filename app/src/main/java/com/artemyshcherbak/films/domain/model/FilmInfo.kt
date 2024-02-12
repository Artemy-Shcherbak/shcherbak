package com.artemyshcherbak.films.domain.model

data class FilmInfo(
    val id: Long,
    val nameRu: String,
    val posterUrl: String,
    val description: String,
    val countries: List<String>,
    val genres: List<String>,
)
