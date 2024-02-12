package com.artemyshcherbak.films.data.network.model.getfilms

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetFilmsResponse(

    @SerialName("films")
    val films: List<FilmResponse>? = null,
)
