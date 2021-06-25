package com.example.cine.retrofit

import retrofit2.Call
import retrofit2.http.GET


interface TheMovieDBService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<POpularMoviesResponces>
}