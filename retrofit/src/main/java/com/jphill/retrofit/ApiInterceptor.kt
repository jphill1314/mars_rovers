package com.jphill.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
        val newUrl = url.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        val updatedRequest = chain.request().newBuilder().url(newUrl).build()
        println("url $newUrl")
        return chain.proceed(updatedRequest)
    }
}