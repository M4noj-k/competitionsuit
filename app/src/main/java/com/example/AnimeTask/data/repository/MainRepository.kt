package com.example.AnimeTask.data.repository

import com.example.AnimeTask.data.HomeRoute
import com.example.AnimeTask.data.api.ApiHelper
import com.example.AnimeTask.remote.NetworkHelper
import com.example.AnimeTask.utils.ApiResult
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getAnimeList(): ApiResult<HomeRoute> =
        NetworkHelper.callApi { apiHelper.getAnimeList() }

}