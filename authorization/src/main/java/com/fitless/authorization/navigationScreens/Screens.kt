package com.fitless.authorization.navigationScreens

import com.fitless.authorization.login.presentation.LoginFragment
import com.fitless.authorization.onboarding.OnBoardingPageFragment
import com.fitless.authorization.registration.registration.presentation.RegistrationFragment
import com.fitless.authorization.registration.usersBio.presentation.UsersBioFragment
import com.fitless.authorization.success.SuccessAuthFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun usersBioFragment() = FragmentScreen { UsersBioFragment() }

    fun onBoardingFragment() = FragmentScreen { OnBoardingPageFragment() }

    fun loginFragment() = FragmentScreen { LoginFragment() }

    fun successFragment() = FragmentScreen { SuccessAuthFragment() }

    fun registrationFragment() = FragmentScreen { RegistrationFragment() }

}