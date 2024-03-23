package com.fitless.onboarding.welcomescreen.presentation

import com.fitless.onboarding.onboarding.OnboardingFragment
import com.fitless.onboarding.welcomescreen.presentation.WelcomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun onboardingFragment() = FragmentScreen { OnboardingFragment() }

}