package com.example.lab5SportsApp.Network

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.lab5SportsApp.model.DTOSport

class Worker(appContext:Context,prams:WorkerParameters):CoroutineWorker(appContext,prams) {
    override suspend fun doWork(): Result {
        val movieApi = RetrofitHelper.getInstance().create(RetrofitService::class.java)
        val response = movieApi.getAllSports()
        if (response.isSuccessful){
            DTOSport.sportsList = response.body()?.sports!!
            Log.e("worker", "doWork:response size ${DTOSport.sportsList.size}" )
        }
        else{
            Log.e("worker", "doWork:response size 0" )
        }
        return Result.success()
    }

}