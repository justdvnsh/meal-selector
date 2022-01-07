package com.example.meal_selector.presentation.screens.launch

import androidx.lifecycle.ViewModel
import com.example.meal_selector.presentation.screens.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class DefaultLaunchViewModel: LaunchViewModel, BaseViewModel() {

    private val startRootActivitySubject: PublishSubject<String> = PublishSubject.create()

    override fun set(viewEvent: LaunchViewModel.ViewEvent): Disposable {
        compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            viewEvent.startScreen()
                .debounce(3000, TimeUnit.MILLISECONDS)
                .subscribe(
                    {
                        startRootActivitySubject.onNext(it)
                    },
                    {}
                )
        )

        return compositeDisposable
    }

    override fun generateViewData(): LaunchViewModel.ViewData {
        return object : LaunchViewModel.ViewData {
            override val startRootActivity: PublishSubject<String>
                get() = startRootActivitySubject
            override val loading: Observable<Boolean>
                get() = Observable.never()
        }
    }

    // something to be removed from here. Just for the git config
}