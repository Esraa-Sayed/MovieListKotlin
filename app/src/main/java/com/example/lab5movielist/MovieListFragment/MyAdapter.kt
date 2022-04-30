package com.example.lab5movielist.MovieListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5movielist.R
import com.example.lab5movielist.model.MovieDataClass

class MyAdapter(private val movies:MutableList<MovieDataClass>,private val setOnClickListener: setOnClickListener):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

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
            holder.movieImage.setImageResource(movie.img)
            holder.movieName.text = movie.movieName
            holder.view.setOnClickListener {setOnClickListener.onClick(movie) }

    }

    override fun getItemCount(): Int {
         return  movies.size
    }

}