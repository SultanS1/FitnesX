package com.fitless.fitnessX.router

import com.fitless.core.CustomRouter
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppRouter(private val router: Router): CustomRouter<FragmentScreen>{

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
