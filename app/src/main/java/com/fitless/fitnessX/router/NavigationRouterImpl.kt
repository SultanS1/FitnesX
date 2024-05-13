package com.fitless.fitnessX.router

import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Implementation of the [NavigationRouter] interface for navigating between fragment screens.
 * This class delegates navigation actions to an underlying [Router] instance.
 * @param router The router used for navigating between screens.
 */
class NavigationRouterImpl(private val router: Router): NavigationRouter<FragmentScreen> {

    override fun navigateTo(screen: FragmentScreen) {
        router.navigateTo(screen)
    }

    override fun pop() {
        router.exit()
    }

    override fun replace(screen: FragmentScreen) {
        router.replaceScreen(screen)
    }

}
