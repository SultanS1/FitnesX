package com.fitless.onboarding.welcomescreen.presentation

import androidx.lifecycle.ViewModel
import com.fitless.onboarding.welcomescreen.domain.NavigationAction
import com.fitless.onboarding.welcomescreen.domain.NavigationViewState
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WelcomeViewModel(private val reducer: WelcomePageReducer) : ViewModel() {

    private val _viewState = MutableStateFlow<NavigationViewState>(reducer.initialState)

    val viewState: StateFlow<NavigationViewState> = _viewState

    fun getStartedButtonClicked() {
        reducer.handleAction(NavigationAction.NavigateToNextFragmentAction)
    }

}