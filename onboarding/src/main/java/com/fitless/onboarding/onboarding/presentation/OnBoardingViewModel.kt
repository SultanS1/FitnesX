package com.fitless.onboarding.onboarding.presentation

import androidx.lifecycle.ViewModel
import com.fitless.onboarding.onboarding.domain.OnBoardingAction
import com.fitless.onboarding.onboarding.domain.OnBoardingReducer
import com.fitless.onboarding.onboarding.domain.OnBoardingViewState
import kotlinx.coroutines.flow.StateFlow

class OnBoardingViewModel(private val reducer: OnBoardingReducer): ViewModel() {

    private val _viewState = reducer.state
    val viewState: StateFlow<OnBoardingViewState> get() =  _viewState

    fun nextStep(action: OnBoardingAction){
        reducer.handleAction(action)
    }

}