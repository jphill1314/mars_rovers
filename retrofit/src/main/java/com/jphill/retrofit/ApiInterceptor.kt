package com.jphill.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url()
        val newUrl = url.newBuilder()
            .addQueryParameter("api_key", "DEMO_KEY")
            .build()

        val updatedRequest = chain.request().newBuilder().url(newUrl).build()
        return chain.proceed(updatedRequest)
    }
}