package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseAction

sealed interface NavigationAction: BaseAction{
    data object NavigateToNextFragmentAction: NavigationAction
}