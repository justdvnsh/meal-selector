package com.example.meal_selector.presentation

import com.example.meal_selector.presentation.screens.launch.DefaultLaunchViewModel
import com.example.meal_selector.presentation.screens.launch.LaunchViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    internal fun provideLaunchScreenViewModel(): DefaultLaunchViewModel {
        return DefaultLaunchViewModel()
    }
}