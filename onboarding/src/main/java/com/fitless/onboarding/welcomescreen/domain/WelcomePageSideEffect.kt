package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.architecture.BaseSideEffect
import com.github.terrakok.cicerone.Screen

sealed class WelcomePageSideEffect: BaseSideEffect {
    data class NavigateToScreen(val screen: Screen) : WelcomePageSideEffect()
}