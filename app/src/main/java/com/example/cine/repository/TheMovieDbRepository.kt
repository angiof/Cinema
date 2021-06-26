package com.example.cine.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.cine.comom.MyApp
import com.example.cine.retrofit.Movie
import com.example.cine.retrofit.POpularMoviesResponces
import com.example.cine.retrofit.TheMovieDBService
import com.example.cine.retrofit.TheMovieDbClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TheMovieDbRepository {

    var theMovieDBService: TheMovieDBService? = null
    var theMovieDbClient: TheMovieDbClient? = null

    //la lista dei filsm che puo cambiare
    var popularMovies: MutableLiveData<List<Movie>>? = null

    init {

        theMovieDbClient= TheMovieDbClient.instance
        theMovieDBService=theMovieDbClient?.getTheMovieDbServices()
        popularMovies=popularMovies()

    }
    fun popularMovies():MutableLiveData<List<Movie>>?{
        if (popularMovies==null){
            popularMovies= MutableLiveData<List<Movie>>()
        }
        val call: Call<POpularMoviesResponces>? =theMovieDBService?.getPopularMovies()
        call?.enqueue(object :Callback<POpularMoviesResponces>{
            override fun onResponse(
                call: Call<POpularMoviesResponces>,
                response: Response<POpularMoviesResponces>
            ) {
                popularMovies?.value = response.body()?.results
            }

            override fun onFailure(call: Call<POpularMoviesResponces>, t: Throwable) {
                Toast.makeText(MyApp.instance, "errore${t.cause}", Toast.LENGTH_SHORT).show()
            }

        })
        return popularMovies
    }

}