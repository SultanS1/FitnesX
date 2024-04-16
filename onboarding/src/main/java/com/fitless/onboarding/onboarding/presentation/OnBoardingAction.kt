package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseAction

sealed interface OnBoardingAction : BaseAction {
	data object OnBoardingStep : OnBoardingAction
}