package com.fitless.onboarding.navigationScreens

import com.fitless.authorization.registration.registration.presentation.RegistrationFragment
import com.fitless.onboarding.onboarding.presentation.OnboardingFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun onboardingFragment() = FragmentScreen { OnboardingFragment() }

    fun authFeature() = FragmentScreen { RegistrationFragment() }

}