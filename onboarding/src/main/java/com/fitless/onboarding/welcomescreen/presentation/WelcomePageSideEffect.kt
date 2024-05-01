package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.core.architecture.BaseSideEffect
import com.github.terrakok.cicerone.Screen

sealed class WelcomePageSideEffect: BaseSideEffect {
    data class NavigateToScreen(val screen: Screen) : WelcomePageSideEffect()
}