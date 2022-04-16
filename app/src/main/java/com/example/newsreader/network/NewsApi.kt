package com.example.newsreader.network

import retrofit2.http.GET

interface NewsApi {

    @GET("")
    suspend fun getNews()
}