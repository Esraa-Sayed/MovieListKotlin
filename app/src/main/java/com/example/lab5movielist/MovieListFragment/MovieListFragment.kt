package com.example.lab5movielist.MovieListFragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5movielist.MovieListActivity.Communicator
import com.example.lab5movielist.MovieListActivity.MainActivity
import com.example.lab5movielist.R
import com.example.lab5movielist.model.DTOMovie
import com.example.lab5movielist.model.MovieDataClass

class movieListFragment : Fragment(), setOnClickListener {
    lateinit var moviesRecyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesRecyclerView = view.findViewById(R.id.moviesRecyclerView)
        moviesRecyclerView.setHasFixedSize(true)

        val myAdapter = MyAdapter(DTOMovie.movieList,this)
        moviesRecyclerView.adapter = myAdapter

        var layoutM = LinearLayoutManager(activity)
        layoutM.orientation = RecyclerView.VERTICAL
        moviesRecyclerView.layoutManager = layoutM


    }

    override fun onClick(movieDataClass: MovieDataClass) {
        val  myActivity:Communicator = activity as Communicator
        myActivity.sendData(movieDataClass);
    }
}