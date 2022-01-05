package com.example.meal_selector.core.apis.meal

import com.example.meal_selector.core.apis.meal.models.Meals
import io.reactivex.Observable
import retrofit2.http.GET

interface MealDataProvider {

    @GET("/api/json/v1/1/categories.php")
    fun getMealCategories(): Observable<Meals>
}