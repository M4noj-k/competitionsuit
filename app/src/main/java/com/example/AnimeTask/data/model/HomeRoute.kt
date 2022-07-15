package com.example.AnimeTask.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeRoute(
    @SerializedName("data")
    @Expose
    var data: List<Anime>? = null,
)

data class Anime(
    @SerializedName("anime_id")
    @Expose
    var animId: Int? = null,

    @SerializedName("anime_name")
    @Expose
    var animName: String? = null,

    @SerializedName("anime_img")
    @Expose
    var animImg: String? = null,
)
