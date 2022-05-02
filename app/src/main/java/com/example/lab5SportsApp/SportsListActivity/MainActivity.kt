package com.example.lab5SportsApp.SportsListActivity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.lab5SportsApp.ActivityTwo.SportDescriptionActivity
import com.example.lab5SportsApp.SportsDescriptionFragment.SportsDescription
import com.example.lab5SportsApp.Network.Worker
import com.example.lab5SportsApp.R
import com.example.lab5SportsApp.model.MovieDataClass

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var fragmentManager:FragmentManager
    lateinit var secondFragment:SportsDescription
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager

        val worker = WorkManager.getInstance()
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val request = OneTimeWorkRequestBuilder<Worker>()
            .setConstraints(constraint)
            .build()
        worker.enqueue(request)
    }

    override fun sendData(movieDataClass: MovieDataClass) {
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            secondFragment = fragmentManager.findFragmentById(R.id.fragmentTwoLandScap) as SportsDescription
            secondFragment.getDatalandscap(movieDataClass)
        }
        else if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val intent = Intent(this, SportDescriptionActivity::class.java).apply {
                putExtra("Data",movieDataClass)
            }
            startActivity(intent)
        }
    }
}