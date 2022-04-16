package com.example.newsreader.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsreader.repository.NewsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    private val newsRepository: NewsRepository
) : ViewModel() {

    fun getNews() {
        viewModelScope.launch {
            try {
                newsRepository.getNews()
            } catch (e: Exception) {
                Log.w("MainViewModel", "getNews: $e")
            }
        }
    }
}