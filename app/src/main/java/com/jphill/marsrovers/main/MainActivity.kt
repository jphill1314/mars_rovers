package com.jphill.marsrovers.main

import android.os.Bundle
import android.view.LayoutInflater
import com.jphill.marsrovers.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }
}
