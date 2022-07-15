package com.example.AnimeTask.remote

import java.io.IOException

open class NoConnectivityException : IOException() {
     fun getError(): String = "No Internet Connection"
}