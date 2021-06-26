package com.example.cine.views.Movies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cine.comom.Constanti
import com.example.cine.databinding.FragmentMovieListBinding
import com.example.cine.retrofit.Movie


class MovieRecyclerViewAdapter(var mValues: List<Movie>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    private var movies: List<Movie> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentMovieListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.textViewTitle.text=mValues[position].title
        holder.img.load(Constanti.IMAGE_BASE_URL+item.poster_path)


    }

    override fun getItemCount(): Int = mValues.size

    fun setData(popularMovies: List<Movie>?) {
        mValues = popularMovies!!
        notifyDataSetChanged()

    }

    inner class ViewHolder(binding: FragmentMovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textViewTitle:TextView=binding.tTitolo
        val img:ImageView=binding.imgMoview

    }

}