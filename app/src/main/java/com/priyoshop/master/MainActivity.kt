package com.priyoshop.master

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_container)
        val navInflater = navController.navInflater
        navController.graph = navInflater.inflate(R.navigation.user_nav)
    }
}
