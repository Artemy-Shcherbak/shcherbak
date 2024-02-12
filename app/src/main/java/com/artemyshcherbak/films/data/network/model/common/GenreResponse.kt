package com.artemyshcherbak.films.data.network.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreResponse(
    @SerialName("genre")
    val genre: String? = null,
)
