package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.architecture.BaseAction

sealed interface WelcomePageAction: BaseAction {
    data object NavigateToNextFragmentAction: WelcomePageAction
}