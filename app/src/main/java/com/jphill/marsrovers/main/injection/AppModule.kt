package com.jphill.marsrovers.main.injection

import com.jphill.marsrovers.main.MainActivity
import com.jphill.marsrovers.main.injection.qualifiers.MainThreadScheduler
import com.jphill.marsrovers.main.injection.qualifiers.NetworkScheduler
import com.jphill.marsrovers.main.injection.scopes.PerActivity
import com.jphill.marsrovers.main.injection.scopes.PerApplication
import com.jphill.retrofit.MarsRoverImageService
import com.jphill.retrofit.getRetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

@Module
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun providesMainActivity(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        @PerApplication
        fun providesRetrofit(): Retrofit = getRetrofitInstance()

        @JvmStatic
        @Provides
        @PerApplication
        fun providesMarsImages(retrofit: Retrofit): MarsRoverImageService =
            retrofit.create(MarsRoverImageService::class.java)

        @JvmStatic
        @Provides
        @PerApplication
        @NetworkScheduler
        fun providesNetworkScheduler() = Schedulers.io()

        @JvmStatic
        @Provides
        @PerApplication
        @MainThreadScheduler
        fun providesMainThreadScheduler() = AndroidSchedulers.mainThread()
    }
}