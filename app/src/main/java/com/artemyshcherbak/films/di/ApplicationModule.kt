package com.artemyshcherbak.films.di

import com.artemyshcherbak.films.core.common.AppDispatchers
import com.artemyshcherbak.films.core.common.Dispatcher
import com.artemyshcherbak.films.data.network.datasource.FilmsKtorDataSource
import com.artemyshcherbak.films.data.network.datasource.FilmsNetworkDataSource
import com.artemyshcherbak.films.data.network.ktor.AppBaseUrl
import com.artemyshcherbak.films.data.network.ktor.KtorClientFactory
import com.artemyshcherbak.films.data.network.ktor.KtorClientFactoryAndroidImpl
import com.artemyshcherbak.films.data.repository.DefaultFilmsRepository
import com.artemyshcherbak.films.data.repository.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

    @Binds
    fun bindFilmsNetworkDataSource(
        filmsKtorDataSource: FilmsKtorDataSource
    ): FilmsNetworkDataSource

    @Binds
    fun bindsCitiesRepository(
        defaultFilmsRepository: DefaultFilmsRepository
    ): FilmsRepository

    companion object {

        @Provides
        @Dispatcher(AppDispatchers.MAIN)
        fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @Dispatcher(AppDispatchers.IO)
        fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Singleton
        @Provides
        internal fun provideKtorClientFactory(): KtorClientFactory = KtorClientFactoryAndroidImpl()

        @Singleton
        @Provides
        internal fun provideHttpClient(ktorClientFactory: KtorClientFactory): HttpClient =
            ktorClientFactory.build()

        @Singleton
        @Provides
        @AppBaseUrl
        internal fun provideBaseUrl(): String = "https://kinopoiskapiunofficial.tech"
    }
}
