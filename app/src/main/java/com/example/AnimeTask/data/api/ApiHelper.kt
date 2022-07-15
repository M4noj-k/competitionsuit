package com.example.AnimeTask.data.api

import com.example.AnimeTask.data.HomeRoute
import retrofit2.Response

interface ApiHelper {
    suspend fun getAnimeList(): Response<HomeRoute>
    suspend fun getAnimeFact(): Response<HomeRoute>
    suspend fun getSpecificAnimeFact(): Response<HomeRoute>
}