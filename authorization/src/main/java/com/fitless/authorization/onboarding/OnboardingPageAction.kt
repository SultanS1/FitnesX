package com.fitless.authorization.onboarding

import com.fitless.core.architecture.BaseAction

sealed interface OnboardingPageAction: BaseAction{

    data object Confirm: OnboardingPageAction

}