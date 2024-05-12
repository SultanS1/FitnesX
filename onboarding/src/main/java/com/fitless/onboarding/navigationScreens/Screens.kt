package com.fitless.onboarding.navigationScreens

import com.fitless.authorization.registration.registration.presentation.RegistrationFragment
import com.fitless.onboarding.onboarding.presentation.OnboardingFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Helper object for managing screen navigation destinations.
 */
object Screens {

    /**
     * Creates a [FragmentScreen] instance for navigating to the onboarding fragment.
     *
     * @return [FragmentScreen] instance for the onboarding fragment.
     */
    fun onboardingFragment() = FragmentScreen { OnboardingFragment() }

    /**
     * Creates a [FragmentScreen] instance for navigating to the authentication feature fragment.
     *
     * @return [FragmentScreen] instance for the authentication feature fragment.
     */
    fun authFeature() = FragmentScreen { RegistrationFragment() }

}