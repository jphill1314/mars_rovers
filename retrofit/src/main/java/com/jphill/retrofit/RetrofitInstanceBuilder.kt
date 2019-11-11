package com.jphill.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofitInstance(apiKey: String): Retrofit {
    val okHttpBuilder = OkHttpClient.Builder()
    okHttpBuilder.addInterceptor(ApiInterceptor(apiKey))

    return Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpBuilder.build())
        .build()
}