package com.example.AnimeTask.data.api

import com.example.AnimeTask.data.Anime
import com.example.AnimeTask.data.HomeRoute
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1")
    suspend fun getAnimeList(): Response<HomeRoute>

    @GET("api/v1/{anime_name}")
    suspend fun getAnimeFact(): Response<HomeRoute> // change response as per need

    @GET("api/v1/{anime_name}/{fact_id}")
    suspend fun getSpecificAnimeFact(): Response<HomeRoute> // change response as per need
}