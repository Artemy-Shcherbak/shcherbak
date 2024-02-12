package com.artemyshcherbak.films.data.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import timber.log.Timber

internal class KtorClientFactoryAndroidImpl : KtorClientFactory {

    override fun build(): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            connectTimeoutMillis = 3000
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Timber.d(message)
                }
            }
            level = LogLevel.NONE
        }
    }
}
