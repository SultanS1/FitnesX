package com.fitless.onboarding.welcomescreen.presentation

import androidx.lifecycle.ViewModel
import com.fitless.onboarding.welcomescreen.domain.WelcomePageAction
import com.fitless.onboarding.welcomescreen.domain.WelcomePageViewState
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WelcomeViewModel(private val reducer: WelcomePageReducer) : ViewModel() {

    private val _viewState = MutableStateFlow<WelcomePageViewState>(reducer.initialState)

    val viewState: StateFlow<WelcomePageViewState> = _viewState

    fun getStartedButtonClicked() {
        reducer.handleAction(WelcomePageAction.NavigateToNextFragmentAction)
        _viewState.value = reducer.initialState
    }

}