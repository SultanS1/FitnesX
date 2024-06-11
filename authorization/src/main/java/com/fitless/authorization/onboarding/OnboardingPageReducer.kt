package com.fitless.authorization.onboarding

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

class OnboardingPageReducer(private val router: NavigationRouter<FragmentScreen>):
    BaseReducer<OnboardingPageState, OnboardingPageAction, OnboardingPageSideEffect>
        (initialState = OnboardingPageState(step = 0)) {

    override fun submitAction(action: OnboardingPageAction) {
        when(action){
            OnboardingPageAction.Confirm -> {
                if (stateValue.step == 2) {
                    router.navigateTo(Screens.loginFragment())
                } else postState { it.copy(step = it.step + 1) }
            }
        }
    }

}