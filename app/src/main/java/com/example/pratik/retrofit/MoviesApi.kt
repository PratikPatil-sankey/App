package com.example.pratik.retrofit


import com.example.pratik.moviefetch.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesApi {
    @Headers(
        "x-rapidapi-key: 52bcb593c5mshc26dc22959e23abp168f54jsnbac14fce8416",
        "x-rapidapi-host: moviesdatabase.p.rapidapi.com"
    )
    @GET("titles/x/upcoming")
    fun getUpcomingMovies(): Call<MovieResponse>
}
