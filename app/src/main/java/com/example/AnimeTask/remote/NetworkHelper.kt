package com.example.AnimeTask.remote

import com.example.AnimeTask.utils.ApiResult
import com.example.AnimeTask.utils.Error
import com.example.AnimeTask.utils.Exception
import com.example.AnimeTask.utils.Loading
import com.example.AnimeTask.utils.Success
import retrofit2.HttpException
import retrofit2.Response

class NetworkHelper {

    companion object {
        suspend fun <T : Any> callApi(
            execute: suspend () -> Response<T>,
        ): ApiResult<T> = try {
            Loading(null)
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Success(body)
            } else {
                Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            Error(code = e.code(), message = e.message())
        } catch (e: Throwable) {
            if (e is NoConnectivityException) {
                Exception(Throwable("Please check internet connection"))
            } else {
                Exception(e)
            }
        }
    }
}