package com.artemyshcherbak.films.core.common

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val appDispatcher: AppDispatchers)

enum class AppDispatchers {
    MAIN,
    IO
}
