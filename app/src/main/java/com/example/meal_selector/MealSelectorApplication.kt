package com.example.meal_selector

import android.app.Application
import android.content.Context
import com.example.meal_selector.core.CoreModule
import com.example.meal_selector.core.repositories.meal.MealRepository
import com.example.meal_selector.presentation.DaggerPresentationComponent
import com.example.meal_selector.presentation.PresentationComponent
import com.example.meal_selector.presentation.PresentationModule
import javax.inject.Inject

class MealSelectorApplication: Application() {

    var presentationComponent: PresentationComponent? = null
        private set

    @Inject
    lateinit var mealRepository: MealRepository

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
        this.presentationComponent = DaggerPresentationComponent
            .builder()
            .presentationModule(PresentationModule())
            .coreModule(CoreModule())
            .build()
        this.presentationComponent!!.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        var instance: MealSelectorApplication? = null
            private set
    }
}