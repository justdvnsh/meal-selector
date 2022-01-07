package com.example.meal_selector.presentation.screens.launch

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.meal_selector.MealSelectorApplication
import com.example.meal_selector.databinding.ActivityLaunchBinding
import com.example.meal_selector.presentation.PresentationComponent
import io.reactivex.subjects.ReplaySubject
import javax.inject.Inject

class LaunchActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: LaunchViewModel

    private val startScreenSubject: ReplaySubject<String> = ReplaySubject.create()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setupUI()
    }

    private fun setupUI() {
        val binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setViewModelViewEvent() {}

    private fun bindViewData() {}

    private fun getPresentationComponent(): PresentationComponent {
        return MealSelectorApplication.instance?.presentationComponent!!
    }
}