package com.artemyshcherbak.films.data.network

import io.ktor.client.statement.HttpResponse

internal val HttpResponse.isSuccessful: Boolean
    get() = status.value in 200..299
