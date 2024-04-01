package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseSideEffect
import com.github.terrakok.cicerone.Screen

sealed class NavigationSideEffect: BaseSideEffect {
    data class NavigateToScreen(val screen: Screen) : NavigationSideEffect()
}