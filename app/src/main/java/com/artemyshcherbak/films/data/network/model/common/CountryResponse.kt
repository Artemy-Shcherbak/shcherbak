package com.artemyshcherbak.films.data.network.model.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryResponse(
    @SerialName("country")
    val country: String? = null,
)
