package com.artemyshcherbak.films.core.common

sealed interface Result<out R> {
    data class Success<out T>(val data: T) : Result<T>
    data class Error(val exception: Throwable? = null) : Result<Nothing>
    data object Loading : Result<Nothing>
}
