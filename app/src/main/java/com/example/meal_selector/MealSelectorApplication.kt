package com.example.meal_selector

import android.app.Application
import com.example.meal_selector.core.CoreModule
import com.example.meal_selector.presentation.DaggerPresentationComponent
import com.example.meal_selector.presentation.PresentationComponent

class MealSelectorApplication: Application() {

    lateinit var presentationComponent: PresentationComponent

    override fun onCreate() {
        super.onCreate()
        this.presentationComponent = DaggerPresentationComponent
            .builder()
            .coreModule(CoreModule())
            .build()
        this.presentationComponent.inject(this)
    }
}