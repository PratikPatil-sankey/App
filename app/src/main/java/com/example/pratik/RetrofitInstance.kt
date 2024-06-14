package com.example.pratik

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://moviesdatabase.p.rapidapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val api: MoviesApi by lazy {
        retrofit.create(MoviesApi::class.java)
    }
}
