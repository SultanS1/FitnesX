package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseState

/**
 * Data class representing the state of the onboarding process.
 *
 * @property onboardingPassed Number of onboarding steps completed.
 * @property progress Overall progress of the onboarding process.
 */
data class OnBoardingViewState(
	val onboardingPassed: Int,
	val progress: Int,
) : BaseState