package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseAction

sealed interface WelcomePageAction: BaseAction{
    data object NavigateToNextFragmentAction: WelcomePageAction
}