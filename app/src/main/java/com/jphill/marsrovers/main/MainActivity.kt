package com.jphill.marsrovers.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jphill.marsrovers.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
