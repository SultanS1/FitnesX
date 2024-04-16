package com.fitless.onboarding.onboarding.domain

import com.fitless.core.BaseAction
import com.fitless.core.BaseReducer
import com.fitless.core.BaseState
import com.fitless.core.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class OnBoardingReducer (private val router: NavigationRouter<FragmentScreen>): BaseReducer<OnBoardingViewState, OnBoardingSideEffect>() {

    override val initialState: OnBoardingViewState = OnBoardingViewState()

    override fun handleAction(action: BaseAction) {
        when(action) {
            is OnBoardingAction.NavigateToAuth -> {
                router.navigateTo(Screens.authFeature())
                postAction { it.copy(navigated = true) }
            }
            is OnBoardingAction.OnBoardingStep -> {
                postAction { it.copy(onboardingPassed = it.onboardingPassed + 1) }
            }
        }
    }
}