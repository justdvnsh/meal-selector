package com.example.meal_selector.core.services

import com.example.meal_selector.core.apis.cocktail.CocktailDataProvider
import com.example.meal_selector.core.apis.meal.MealDataProvider

interface NetworkService {
    fun getMealDataProvider(): MealDataProvider
    fun getCocktailDataProvider(): CocktailDataProvider
}