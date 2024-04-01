package com.fitless.fitnessX.router

import com.fitless.core.NavigationRouter
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen

class NavigationRouterImpl(private val router: Router): NavigationRouter<FragmentScreen>{

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
