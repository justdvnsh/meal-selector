package com.example.meal_selector.core.services.debugInterceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class DebugInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestUrl = chain.request().url()
        Log.i("Calling :- ", requestUrl.toString())
        return chain.proceed(chain.request())
    }
}