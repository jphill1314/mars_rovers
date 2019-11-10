package com.jphill.marsrovers.main

import android.app.Application
import com.jphill.marsrovers.main.injection.AppComponent
import com.jphill.marsrovers.main.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: AndroidInjector<Any>
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
        component.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}