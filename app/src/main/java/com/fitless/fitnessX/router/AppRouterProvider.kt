package com.fitless.fitnessX.router

import com.fitless.core.AppModuleDependencies
import com.fitless.core.CustomRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppRouterProvider(private val router: AppRouter): AppModuleDependencies<FragmentScreen> {
        override fun provideRouter(): CustomRouter<FragmentScreen> {
            return router
    }
}