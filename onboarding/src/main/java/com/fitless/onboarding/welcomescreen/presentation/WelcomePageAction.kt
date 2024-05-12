package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.core.architecture.BaseAction

/**
 * Sealed interface representing actions related to the welcome page.
 */
sealed interface WelcomePageAction: BaseAction {
    /**
     * Object representing the action to navigate to the next fragment.
     */
    data object NavigateToNextFragmentAction: WelcomePageAction
}