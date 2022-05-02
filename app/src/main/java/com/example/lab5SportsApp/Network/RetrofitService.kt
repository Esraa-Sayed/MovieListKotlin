package com.example.lab5SportsApp.Network

import com.example.lab5SportsApp.model.Sports
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/v1/json/2/all_sports.php")
    suspend fun getAllSports(): Response<Sports>
}