package com.example.newsreader.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import coil.load
import com.example.newsreader.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val adapter = NewsListAdapter()

        setContentView(binding.root)
        binding.newsList.adapter = adapter

        mainViewModel.news.observe(this) { newsResponse ->
            adapter.submitList(newsResponse.articles)
        }
    }
}