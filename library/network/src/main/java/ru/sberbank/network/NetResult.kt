package ru.sberbank.network

sealed class NetResult<out T: Any> {
    data class Success<out T : Any>(val statusCode: Int, val data: T) : NetResult<T>()
    data class Failure(val statusCode: Int) : NetResult<Nothing>()
    object NetworkError : NetResult<Nothing>()
}
