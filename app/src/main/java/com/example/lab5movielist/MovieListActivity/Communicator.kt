package com.example.lab5movielist.MovieListActivity

import com.example.lab5movielist.model.MovieDataClass

interface Communicator {
    fun sendData(movieDataClass: MovieDataClass)
}