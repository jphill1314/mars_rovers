package com.jphill.marsrovers.main.injection

import com.jphill.marsrovers.main.MainActivity
import com.jphill.marsrovers.main.injection.scopes.PerActivity
import com.jphill.marsrovers.main.injection.scopes.PerApplication
import com.jphill.retrofit.MarsRoverImageService
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun providesMainActivity(): MainActivity

    @Module
    companion object {
        @Provides
        @PerApplication
        fun providesRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        @Provides
        @PerApplication
        fun providesMarsImages(retrofit: Retrofit) = retrofit.create(MarsRoverImageService::class.java)
    }
}