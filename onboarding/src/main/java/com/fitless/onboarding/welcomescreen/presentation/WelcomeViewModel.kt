package com.fitless.onboarding.welcomescreen.presentation

import androidx.lifecycle.ViewModel
import com.fitless.core.BaseReducer
import com.fitless.core.CustomRouter
import com.fitless.onboarding.welcomescreen.domain.NavigationAction
import com.fitless.onboarding.welcomescreen.domain.NavigationViewState
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WelcomeViewModel(private val reducer: WelcomePageReducer) : ViewModel() {

    private val _viewState = MutableStateFlow(NavigationViewState(navigated = false))
    val viewState: StateFlow<NavigationViewState> = _viewState

    fun getStartedButtonClicked() {
        val newState = reducer.reduce(_viewState.value, NavigationAction.GetStartedBtnClicked)
        _viewState.value = newState as NavigationViewState
    }
}