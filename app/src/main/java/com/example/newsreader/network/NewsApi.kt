package com.example.newsreader.network

import com.example.newsreader.data.dto.request.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") county: String = "us",
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = "966d7f4eab7d428faf042d67ec3f0389"
    ): NewsResponse
}