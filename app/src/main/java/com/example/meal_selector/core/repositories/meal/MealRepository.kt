package com.example.meal_selector.core.repositories.meal

import com.example.meal_selector.core.apis.meal.models.Meal
import com.example.meal_selector.core.apis.meal.models.Meals
import io.reactivex.Observable

interface MealRepository {
    fun getMealCategories(): Observable<Meals>
    fun getSingleMealDetail(
        mealId: String
    ): Observable<Meal>
}