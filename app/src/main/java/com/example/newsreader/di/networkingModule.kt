package com.example.newsreader.di

import com.example.newsreader.network.NewsApi
import com.example.newsreader.repository.NewsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private var BASE_URL = "https://newsapi.org/v2/"

private val networkModule = module {
    single { provideDefaultHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideMoshi() }
}

private val apiModule = module {
    single { provideNewsApi(get()) }
}

private val repositoryModule = module {
    single { NewsRepository(get()) }
}

private fun provideDefaultHttpClient(): OkHttpClient =
    OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()

private fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit
    .Builder()
    .client(client)
    .baseUrl(BASE_URL)
    .addConverterFactory(
        MoshiConverterFactory
            .create(moshi)
    )
    .build()

private fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

val networkingModule = listOf(networkModule, apiModule, repositoryModule)