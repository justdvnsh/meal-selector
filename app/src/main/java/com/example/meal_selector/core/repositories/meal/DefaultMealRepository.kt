package com.example.meal_selector.core.repositories.meal

import com.example.meal_selector.core.apis.meal.MealDataProvider
import com.example.meal_selector.core.apis.meal.models.Meal
import com.example.meal_selector.core.apis.meal.models.Meals
import io.reactivex.Observable

class DefaultMealRepository(
    private val mealDataProvider: MealDataProvider
): MealRepository {
    override fun getMealCategories(): Observable<Meals> {
        TODO("Not yet implemented")
    }

    override fun getSingleMealDetail(mealId: String): Observable<Meal> {
        TODO("Not yet implemented")
    }
}