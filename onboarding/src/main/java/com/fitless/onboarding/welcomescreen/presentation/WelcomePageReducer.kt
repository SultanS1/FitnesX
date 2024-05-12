package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class WelcomePageReducer(
    private val router: NavigationRouter<FragmentScreen>,
) : BaseReducer<WelcomePageViewState, WelcomePageAction, WelcomePageSideEffect>(
    initialState = WelcomePageViewState(navigated = false)
) {

    override fun submitAction(action: WelcomePageAction) {
        when(action){
            is WelcomePageAction.NavigateToNextFragmentAction -> {
                postState {
                    it.copy(navigated = true)
                }
                router.navigateTo(Screens.onboardingFragment())
            }
        }
    }

}