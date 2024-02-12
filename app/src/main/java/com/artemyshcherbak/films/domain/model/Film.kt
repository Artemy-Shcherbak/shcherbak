package com.artemyshcherbak.films.domain.model

data class Film(
    val id: Long,
    val nameRu: String,
    val posterUrl: String,
    val year: String,
    val countries: List<String>,
    val genres: List<String>,
)
