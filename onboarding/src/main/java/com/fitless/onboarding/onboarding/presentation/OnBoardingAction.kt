package com.fitless.onboarding.onboarding.presentation

import com.fitless.core.architecture.BaseAction

/**
 * Sealed interface representing actions related to the onboarding process.
 */
sealed interface OnBoardingAction : BaseAction {

	/**
	 * Object representing a single step in the onboarding process.
	 */
	data object OnBoardingStep : OnBoardingAction
}