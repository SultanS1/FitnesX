package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseAction
import com.fitless.core.BaseReducer
import com.fitless.core.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class WelcomePageReducer(private val router: NavigationRouter<FragmentScreen>): BaseReducer<NavigationViewState, NavigationSideEffect>() {

    override val initialState: NavigationViewState = NavigationViewState(navigated = false)

    override fun handleAction(action: BaseAction) {
        when (action) {
            is NavigationAction.NavigateToNextFragmentAction -> {
                router.replace(Screens.onboardingFragment())
                initialState.copy(navigated = true)
            }
        }
    }

}