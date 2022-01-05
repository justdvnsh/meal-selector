package com.example.meal_selector.presentation

import com.example.meal_selector.MealSelectorApplication
import com.example.meal_selector.core.CoreModule
import com.example.meal_selector.core.apis.meal.MealDataProvider
import com.example.meal_selector.core.repositories.cocktails.CocktailRepository
import com.example.meal_selector.core.repositories.meal.MealRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface PresentationComponent {
    fun inject(mealSelectorApplication: MealSelectorApplication)

    fun mealRepository(): MealRepository
    fun cocktailRepository(): CocktailRepository
}