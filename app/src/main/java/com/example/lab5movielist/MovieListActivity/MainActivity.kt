package com.example.lab5movielist.MovieListActivity

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.example.lab5movielist.ActivityTwo.MovieDescriptionActivity
import com.example.lab5movielist.MovieDescriptionFragment.MovieDescription
import com.example.lab5movielist.R
import com.example.lab5movielist.model.MovieDataClass

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var fragmentManager:FragmentManager
    lateinit var secondFragment:MovieDescription
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
    }

    override fun sendData(movieDataClass: MovieDataClass) {
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            secondFragment = fragmentManager.findFragmentById(R.id.fragmentTwoLandScap) as MovieDescription
            secondFragment.getDatalandscap(movieDataClass)
        }
        else if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            val intent = Intent(this, MovieDescriptionActivity::class.java).apply {
                putExtra("Data",movieDataClass)
            }
            startActivity(intent)
        }
    }
}