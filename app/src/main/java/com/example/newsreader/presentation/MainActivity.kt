package com.example.newsreader.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsreader.data.dto.request.NewsResponse
import com.example.newsreader.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel.news.observe(this) { newsResponse ->
            binding.string.text = newsResponse.articles.toString()
        }
    }
}