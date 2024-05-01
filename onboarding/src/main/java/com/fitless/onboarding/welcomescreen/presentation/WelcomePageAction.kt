package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.core.architecture.BaseAction

sealed interface WelcomePageAction: BaseAction {
    data object NavigateToNextFragmentAction: WelcomePageAction
}