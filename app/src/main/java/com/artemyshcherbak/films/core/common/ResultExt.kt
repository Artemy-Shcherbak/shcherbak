package com.artemyshcherbak.films.core.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

suspend inline fun <T, R> Result<T>.map(crossinline transform: suspend (value: T) -> R): Result<R> =
    when (this) {
        is Result.Success ->
            try {
                Result.Success(transform(data))
            } catch (e: Throwable) {
                Timber.w(e)
                Result.Error(e)
            }

        is Result.Loading -> Result.Loading
        is Result.Error -> this
    }

inline fun <T, R> Flow<Result<T>>.mapResult(crossinline transform: suspend (value: T) -> R): Flow<Result<R>> =
    map { it.map(transform) }
