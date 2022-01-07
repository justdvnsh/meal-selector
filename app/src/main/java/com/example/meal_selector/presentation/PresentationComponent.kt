package com.example.meal_selector.presentation

import com.example.meal_selector.MealSelectorApplication
import com.example.meal_selector.core.CoreModule
import com.example.meal_selector.core.apis.meal.MealDataProvider
import com.example.meal_selector.core.repositories.cocktails.CocktailRepository
import com.example.meal_selector.core.repositories.meal.MealRepository
import com.example.meal_selector.presentation.screens.launch.DefaultLaunchViewModel
import com.example.meal_selector.presentation.screens.launch.LaunchActivity
import com.example.meal_selector.presentation.screens.launch.LaunchViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, PresentationModule::class])
interface PresentationComponent {
    fun inject(mealSelectorApplication: MealSelectorApplication)
    fun inject(launchActivity: LaunchActivity)

    fun mealRepository(): MealRepository
    fun cocktailRepository(): CocktailRepository
    fun launchViewModel(): DefaultLaunchViewModel
}