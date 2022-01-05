package com.example.meal_selector.core.services.retrofit

import com.example.meal_selector.BuildConfig
import com.example.meal_selector.core.apis.cocktail.CocktailDataProvider
import com.example.meal_selector.core.apis.meal.MealDataProvider
import com.example.meal_selector.core.services.NetworkService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkService(
    private val client: OkHttpClient,
): NetworkService {

    private fun isDevBuild() = BuildConfig.BUILD_TYPE.equals("debug", true)

    private var mealDataProvider: MealDataProvider? = null
    private var cocktailDataProvider: CocktailDataProvider? = null

    private val retrofit = if (isDevBuild()) Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    else Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun getMealDataProvider(): MealDataProvider {
        if (mealDataProvider == null) {
            return retrofit.create(MealDataProvider::class.java)
        }
        return mealDataProvider!!
    }

    override fun getCocktailDataProvider(): CocktailDataProvider {
        if (cocktailDataProvider == null) return retrofit.create(CocktailDataProvider::class.java)
        return cocktailDataProvider!!
    }


}