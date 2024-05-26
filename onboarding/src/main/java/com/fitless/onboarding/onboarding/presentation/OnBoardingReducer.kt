package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Reducer class for managing the state and actions of the onboarding process.
 *
 * @property router Instance of [NavigationRouter] for navigating between fragments.
 */
class OnBoardingReducer(
	private val router: NavigationRouter<FragmentScreen>,
) : BaseReducer<OnBoardingViewState, OnBoardingAction, OnBoardingSideEffect>(
	initialState = OnBoardingViewState(
		onboardingPassed = 1, progress = 0
	)
) {

	/**
	 * Handles the submission of actions related to the onboarding process.
	 *
	 * @param action Action to be processed.
	 */
	override fun submitAction(action: OnBoardingAction) {
		when (action) {
			is OnBoardingAction.OnBoardingStep -> {
				postState { state ->
					state.copy(
						onboardingPassed = state.onboardingPassed + 1,
						progress = state.onboardingPassed * 25 // Each step increments progress by 25%
					)
				}
				if (stateValue.progress == 100) {
					router.navigateTo(Screens.authFeature())
				}
			}
		}
	}
	
}