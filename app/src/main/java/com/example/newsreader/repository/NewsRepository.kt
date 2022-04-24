package com.example.newsreader.repository

import com.example.newsreader.data.dto.request.NewsResponse
import com.example.newsreader.network.NewsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class NewsRepository(
    private val newsApi: NewsApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getNews(): NewsResponse = newsApi.getNews()
}