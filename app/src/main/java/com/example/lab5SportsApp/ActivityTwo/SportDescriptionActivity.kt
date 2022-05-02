package com.example.lab5SportsApp.ActivityTwo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab5SportsApp.SportsDescriptionFragment.SportsDescription
import com.example.lab5SportsApp.R
import com.example.lab5SportsApp.model.MovieDataClass

class SportDescriptionActivity : AppCompatActivity() {
    lateinit var movieDataClass: MovieDataClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport_description)
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
           finish()
        }
        movieDataClass = intent.getSerializableExtra("Data") as MovieDataClass
    }

    override fun onResume() {
        super.onResume()
        val fragmentManager = supportFragmentManager
        val movieDescription = fragmentManager.findFragmentById(R.id.fragmentTwo) as SportsDescription
        movieDescription.getDatalandscap(movieDataClass)
    }
    
}