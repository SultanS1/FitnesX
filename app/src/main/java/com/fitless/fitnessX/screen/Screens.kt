package com.fitless.fitnessX.screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.fitless.onboarding.onboarding.OnboardingFragment
import com.fitless.onboarding.welcomescreen.presentation.WelcomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class Screens {

    class WelcomeScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = WelcomeFragment()
    }

    class OnBoardingScreen : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = OnboardingFragment()
    }

}