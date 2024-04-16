package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.fitless.onboarding.navigationScreens.Screens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class OnBoardingReducer(
	private val router: NavigationRouter<FragmentScreen>,
) : BaseReducer<OnBoardingViewState, OnBoardingAction>(
	initialState = OnBoardingViewState(
		onboardingPassed = 1, progress = 25
	)
) {
	
	override fun submitAction(action: OnBoardingAction) {
		when (action) {
			is OnBoardingAction.OnBoardingStep -> {
				postState { state ->
					state.copy(
						onboardingPassed = state.onboardingPassed + 1,
						progress = state.onboardingPassed * 25
					)
				}
				if (stateValue.progress == 100) {
					router.navigateTo(Screens.authFeature())
				}
			}
		}
	}
	
}