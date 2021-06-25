package com.example.cine.retrofit

import retrofit2.Call
import retrofit2.http.GET


interface TheMovieDBServices {

    @GET("movie/popular")
    fun getPopularMovies(): Call<POpularMoviesResponces>
}