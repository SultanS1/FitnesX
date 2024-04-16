package com.fitless.onboarding.onboarding.domain

import com.fitless.core.BaseState

data class OnBoardingViewState(
    val navigated: Boolean = false,
    var onboardingPassed: Int = 1
): BaseState