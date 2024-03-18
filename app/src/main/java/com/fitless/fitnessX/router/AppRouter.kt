package com.fitless.fitnessX.router

import com.fitless.fitnessX.screen.Screens
import com.fitless.onboarding.welcomescreen.presentation.WelcomScreenRouter
import com.github.terrakok.cicerone.Router

class AppRouter(private val router: Router): WelcomScreenRouter {

    init {
        router.replaceScreen(Screens.WelcomeScreen())
    }

//    fun onResume() {
//        navigatorHolder.setNavigator(AppNavigator(activity, R.id.container))
//    }
//
//    fun onPause() {
//        navigatorHolder.removeNavigator()
//    }

    override fun navigateToOnBoarding() {
        router.navigateTo(Screens.OnBoardingScreen())
    }

}
