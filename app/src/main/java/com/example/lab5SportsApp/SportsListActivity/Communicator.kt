package com.example.lab5SportsApp.SportsListActivity

import com.example.lab5SportsApp.model.MovieDataClass

interface Communicator {
    fun sendData(movieDataClass: MovieDataClass)
}