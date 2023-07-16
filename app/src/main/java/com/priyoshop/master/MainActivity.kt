package com.priyoshop.master

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.myapp.navigations.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navGraphId = when (BuildConfig.FLAVOR) {
            "retail" -> navigation.user_nav_retail
            "logistic" -> navigation.user_nav_logistion
            else -> navigation.user_nav_retail
        }

        val navController = findNavController(R.id.nav_host_container)
        val navInflater = navController.navInflater

        // Inflate the appropriate navigation graph based on the flavor
        val navGraph = when (BuildConfig.FLAVOR) {
            "retail" -> {
                navInflater.inflate(navigation.user_nav_retail)
            }

            "logistic" -> {
                navInflater.inflate(navigation.user_nav_logistion)
            }

            else -> {
                navInflater.inflate(navGraphId)
            }
        }

        navController.graph = navGraph
    }
}
