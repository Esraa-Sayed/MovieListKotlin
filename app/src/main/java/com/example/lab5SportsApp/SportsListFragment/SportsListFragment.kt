package com.example.lab5SportsApp.SportsListFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5SportsApp.SportsListActivity.Communicator
import com.example.lab5SportsApp.Network.RetrofitHelper
import com.example.lab5SportsApp.Network.RetrofitService
import com.example.lab5SportsApp.R
import com.example.lab5SportsApp.model.DTOSport
import com.example.lab5SportsApp.model.MovieDataClass
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        return inflater.inflate(R.layout.fragment_sport_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesRecyclerView = view.findViewById(R.id.moviesRecyclerView)
        moviesRecyclerView.setHasFixedSize(true)



        var layoutM = LinearLayoutManager(activity)
        layoutM.orientation = RecyclerView.VERTICAL
        moviesRecyclerView.layoutManager = layoutM

        val myAdapter = MyAdapter(requireContext(),DTOSport.sportsList,this)
        moviesRecyclerView.adapter = myAdapter

        val handler = CoroutineExceptionHandler { _, exception ->
            Log.e("Error",  "CoroutineExceptionHandler got $exception" )
            println("CoroutineExceptionHandler got $exception")
        }
        lifecycle.coroutineScope.launch(handler) {
               val movieApi = RetrofitHelper.getInstance().create(RetrofitService::class.java)
               val response = movieApi.getAllSports()
               withContext(Dispatchers.Main) {
                   if (response.isSuccessful) {
                       DTOSport.sportsList = response.body()?.sports!!
                       myAdapter.setMovies(DTOSport.sportsList)
                       myAdapter.notifyDataSetChanged()
                       Log.e("Yes", "onViewCreated: ")
                   }
               }
        }


    }

    override fun onClick(movieDataClass: MovieDataClass) {
        val  myActivity:Communicator = activity as Communicator
        myActivity.sendData(movieDataClass);
    }
}