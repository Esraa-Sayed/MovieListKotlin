package com.example.lab5movielist.ActivityTwo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.lab5movielist.MovieDescriptionFragment.MovieDescription
import com.example.lab5movielist.R
import com.example.lab5movielist.model.MovieDataClass

class MovieDescriptionActivity : AppCompatActivity() {
    lateinit var movieDataClass: MovieDataClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_description)
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
           finish()
        }
        movieDataClass = intent.getSerializableExtra("Data") as MovieDataClass
    }

    override fun onResume() {
        super.onResume()
        val fragmentManager = supportFragmentManager
        val movieDescription = fragmentManager.findFragmentById(R.id.fragmentTwo) as MovieDescription
        movieDescription.getDatalandscap(movieDataClass)
    }
    
}