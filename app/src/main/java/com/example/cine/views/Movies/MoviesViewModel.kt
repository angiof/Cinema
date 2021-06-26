package com.example.cine.views.Movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cine.repository.TheMovieDbRepository
import com.example.cine.retrofit.Movie

class MoviesViewModel : AndroidViewModel(Application()) {
    private var theMovieDbRepository: TheMovieDbRepository = TheMovieDbRepository()
    private var popularMovies: LiveData<List<Movie>> = theMovieDbRepository?.popularMovies()!!


    fun getPopularMovies(): LiveData<List<Movie>> {
        return popularMovies
    }

}