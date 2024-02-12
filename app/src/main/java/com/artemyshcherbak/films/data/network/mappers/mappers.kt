package com.artemyshcherbak.films.data.network.mappers

import com.artemyshcherbak.films.core.common.NO_VALUE
import com.artemyshcherbak.films.data.network.model.getfilminfo.FilmInfoResponse
import com.artemyshcherbak.films.data.network.model.getfilms.FilmResponse
import com.artemyshcherbak.films.domain.model.Film
import com.artemyshcherbak.films.domain.model.FilmInfo

fun FilmResponse?.asExternalModel(): Film? = this?.let {
    Film(
        id = id ?: NO_VALUE,
        nameRu = nameRu.orEmpty(),
        posterUrl = posterUrl.orEmpty(),
        year = year.orEmpty(),
        countries = countries?.map { it.country.orEmpty() }.orEmpty(),
        genres = genres?.map { it.genre.orEmpty() }.orEmpty(),
    )
}

fun List<FilmResponse>.asExternalModelList() = mapNotNull { it.asExternalModel() }

fun FilmInfoResponse.asExternalModel(): FilmInfo = this.let {
    FilmInfo(
        id = id ?: NO_VALUE,
        nameRu = nameRu.orEmpty(),
        posterUrl = posterUrl.orEmpty(),
        description = description.orEmpty(),
        countries = countries?.map { it.country.orEmpty() }.orEmpty(),
        genres = genres?.map { it.genre.orEmpty() }.orEmpty(),
    )
}
