package com.example.meal_selector.core

import android.os.Build
import com.example.meal_selector.BuildConfig
import com.example.meal_selector.core.commons.constants.Constants
import com.example.meal_selector.core.services.NetworkService
import com.example.meal_selector.core.services.debugInterceptor.DebugInterceptor
import com.example.meal_selector.core.services.retrofit.RetrofitNetworkService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideNetworkService(
        client: OkHttpClient
    ): NetworkService = RetrofitNetworkService(client)

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: DebugInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun providesInterceptor(): DebugInterceptor = DebugInterceptor()
}