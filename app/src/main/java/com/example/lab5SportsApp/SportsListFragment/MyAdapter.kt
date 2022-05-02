package com.example.lab5SportsApp.SportsListFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.lab5SportsApp.R
import com.example.lab5SportsApp.model.MovieDataClass

class MyAdapter(var context: Context, private var movies:MutableList<MovieDataClass>, private val setOnClickListener: setOnClickListener):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view) {
        val movieName:TextView = view.findViewById(R.id.movieName)
        val movieImage: ImageView = view.findViewById(R.id.movieImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           val movie:MovieDataClass  = movies[position]
        Glide.with(context)
            .load(movie.strSportThumb).apply(RequestOptions().override(200, 200))
            .into(holder.movieImage)
            holder.movieName.text = movie.strSport
            holder.view.setOnClickListener {setOnClickListener.onClick(movie) }

    }

    override fun getItemCount(): Int {
         return  movies.size
    }
    fun setMovies(movies:MutableList<MovieDataClass>){
        this.movies = movies
    }


}