package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseReducer
import com.fitless.core.BaseState
import com.fitless.core.CustomRouter
import com.fitless.onboarding.welcomescreen.presentation.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class WelcomePageReducer(private val router: CustomRouter<FragmentScreen>): BaseReducer<NavigationViewState, NavigationAction> {

    override fun reduce(currentState: NavigationViewState, action: NavigationAction): BaseState {
        return when(action){
            is NavigationAction.NavigateToNextFragmentAction -> {
                router.replace(Screens.onboardingFragment())
                currentState.copy(navigated = true)
            }
        }
    }
}