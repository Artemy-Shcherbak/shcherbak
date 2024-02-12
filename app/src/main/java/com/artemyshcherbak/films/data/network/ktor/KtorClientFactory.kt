package com.artemyshcherbak.films.data.network.ktor

import io.ktor.client.*

internal interface KtorClientFactory {

    fun build(): HttpClient
}
