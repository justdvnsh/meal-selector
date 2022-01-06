package com.example.meal_selector.presentation.screens.base

import io.reactivex.Observable

interface ViewModel {

    interface ViewEvent {
        fun backButtonPressed(): Observable<Long>
        fun checkConnectivityStatus(): Observable<Boolean>
    }

    interface ViewData {
        val loading: Observable<Boolean>
    }

    interface Output

    interface Input
}