package com.artemyshcherbak.films.data.network.model.getfilminfo

import com.artemyshcherbak.films.data.network.model.common.CountryResponse
import com.artemyshcherbak.films.data.network.model.common.GenreResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmInfoResponse(

    @SerialName("kinopoiskId")
    val id: Long? = null,

    @SerialName("nameRu")
    val nameRu: String? = null,

    @SerialName("posterUrl")
    val posterUrl: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("countries")
    val countries: List<CountryResponse>? = null,

    @SerialName("genres")
    val genres: List<GenreResponse>? = null,
)
