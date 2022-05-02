package com.example.lab5SportsApp.model

import java.io.Serializable

data class MovieDataClass(var strSport:String, var strSportThumb:String, var strSportDescription:String):Serializable
data class Sports(var sports:MutableList<MovieDataClass>)
