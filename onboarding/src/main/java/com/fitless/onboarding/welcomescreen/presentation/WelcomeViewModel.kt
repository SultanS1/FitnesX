package com.fitless.onboarding.welcomescreen.presentation

import androidx.lifecycle.ViewModel

class WelcomeViewModel(private val router: WelcomScreenRouter): ViewModel() {

    fun navigateToOnBoard(){
        router.navigateToOnBoarding()
    }

}