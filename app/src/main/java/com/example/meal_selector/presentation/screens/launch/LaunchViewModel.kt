package com.example.meal_selector.presentation.screens.launch

import com.example.meal_selector.presentation.screens.base.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


interface LaunchViewModel: ViewModel {

    fun set(viewEvent: LaunchViewModel.ViewEvent): Disposable
    fun generateViewData(): LaunchViewModel.ViewData

    interface ViewEvent: ViewModel.ViewEvent {
        fun startScreen(): Observable<String>
    }

    interface ViewData: ViewModel.ViewData {
        val startRootActivity: PublishSubject<String>
    }
}