package com.example.cine.views.Movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cine.R
import com.example.cine.retrofit.Movie

/**
 * A fragment representing a list of Items.
 */
class MovieListFragment : Fragment() {

    private var columnCount = 2
    private lateinit var viewModel: MoviesViewModel
    private lateinit var movieAdapter :MovieRecyclerViewAdapter
    private var popularMovies:List<Movie> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list_list, container, false)

        //prendiamo il viewModel
        viewModel =ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = movieAdapter
            }
        }
        viewModel.getPopularMovies().observe(viewLifecycleOwner, {
           popularMovies=it
            movieAdapter.setData(popularMovies)
        })
        return view
    }

}