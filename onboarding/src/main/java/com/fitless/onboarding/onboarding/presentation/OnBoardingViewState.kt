package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseState

data class OnBoardingViewState(
	val onboardingPassed: Int,
	val progress: Int,
) : BaseState