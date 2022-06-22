package com.example.homekliring.utils

sealed class Resource <T> (
    val statusCode: Int = 0,
    val message: String? = null,
    val data: T? = null
) {
    class Success<T>(data: T) : Resource<T>(data = data)

    class Error<T>(statusCode: Int, message: String, data: T? = null) : Resource<T>(statusCode = statusCode, message = message, data = data)

    class Loading<T>(data: T? = null) : Resource<T>(data = data)
}
