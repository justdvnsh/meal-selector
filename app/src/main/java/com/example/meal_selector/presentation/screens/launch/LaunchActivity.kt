package com.example.meal_selector.presentation.screens.launch

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.meal_selector.MealSelectorApplication
import com.example.meal_selector.databinding.ActivityLaunchBinding
import com.example.meal_selector.presentation.PresentationComponent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject

class LaunchActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: DefaultLaunchViewModel

    private val startScreenSubject: ReplaySubject<String> = ReplaySubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPresentationComponent().inject(this)
        setViewModelViewEvent()
        bindViewData()
    }

    private fun setViewModelViewEvent() {
        val viewEvent = object: LaunchViewModel.ViewEvent {
            override fun startScreen(): Observable<String> = startScreenSubject

            override fun backButtonPressed(): Observable<Long> = Observable.never()

            override fun checkConnectivityStatus(): Observable<Boolean> = Observable.never()
        }

        viewModel.set(viewEvent)
    }

    override fun onResume() {
        super.onResume()
        startScreenSubject.onNext("JUST START")
    }

    private fun bindViewData() {
        val viewData = viewModel.generateViewData()

        viewData.startRootActivity
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            },
            {
                Log.e("LAUNCH ACTIVITY -> ", it.message.toString())
            }
        )
    }

    private fun getPresentationComponent(): PresentationComponent {
        return MealSelectorApplication.instance?.presentationComponent!!
    }
}