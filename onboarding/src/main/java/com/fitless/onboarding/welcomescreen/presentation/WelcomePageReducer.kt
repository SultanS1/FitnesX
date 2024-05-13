package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Reducer responsible for managing the state of the welcome page.
 *
 * @param router NavigationRouter instance for handling navigation between fragments.
 */
class WelcomePageReducer(
    private val router: NavigationRouter<FragmentScreen>,
) : BaseReducer<WelcomePageViewState, WelcomePageAction, WelcomePageSideEffect>(
    initialState = WelcomePageViewState(navigated = false)
) {

    /**
     * Submits the provided action to update the state of the welcome page.
     *
     * @param action The action to be processed.
     */
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