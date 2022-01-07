package com.example.meal_selector

import android.app.Application
import com.example.meal_selector.core.CoreModule
import com.example.meal_selector.presentation.DaggerPresentationComponent
import com.example.meal_selector.presentation.PresentationComponent
import com.example.meal_selector.presentation.PresentationModule

class MealSelectorApplication: Application() {

    lateinit var presentationComponent: PresentationComponent

    override fun onCreate() {
        super.onCreate()
        this.presentationComponent = DaggerPresentationComponent
            .builder()
            .presentationModule(PresentationModule())
            .coreModule(CoreModule())
            .build()
        this.presentationComponent.inject(this)
    }

    companion object {
        var instance: MealSelectorApplication? = null
            private set
    }
}