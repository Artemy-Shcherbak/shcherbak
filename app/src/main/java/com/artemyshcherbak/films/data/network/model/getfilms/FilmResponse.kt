package com.artemyshcherbak.films.data.network.model.getfilms

import com.artemyshcherbak.films.data.network.model.common.CountryResponse
import com.artemyshcherbak.films.data.network.model.common.GenreResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(

    @SerialName("filmId")
    val id: Long? = null,

    @SerialName("nameRu")
    val nameRu: String? = null,

    @SerialName("posterUrlPreview")
    val posterUrl: String? = null,

    @SerialName("year")
    val year: String? = null,

    @SerialName("countries")
    val countries: List<CountryResponse>? = null,

    @SerialName("genres")
    val genres: List<GenreResponse>? = null,
)
