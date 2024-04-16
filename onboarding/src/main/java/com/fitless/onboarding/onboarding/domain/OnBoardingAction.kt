package com.fitless.onboarding.onboarding.domain

import com.fitless.core.BaseAction

sealed interface OnBoardingAction: BaseAction {
    data object NavigateToAuth: OnBoardingAction
    data object OnBoardingStep: OnBoardingAction
}