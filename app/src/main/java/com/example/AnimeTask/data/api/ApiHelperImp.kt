package com.example.AnimeTask.data.api

import com.example.AnimeTask.data.HomeRoute
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImp @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getAnimeList(): Response<HomeRoute> {
        return apiService.getAnimeList()
    }

    override suspend fun getAnimeFact(): Response<HomeRoute> {
        return apiService.getAnimeFact()
    }

    override suspend fun getSpecificAnimeFact(): Response<HomeRoute> {
        return apiService.getSpecificAnimeFact()
    }
}