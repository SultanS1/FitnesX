package com.fitless.fitnessX.di

import com.fitless.core.NavigationRouter
import com.fitless.fitnessX.application.MainApp
import com.fitless.fitnessX.router.NavigationRouterImpl
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.dsl.module

val appModule =  module {

    single<NavigationRouter<FragmentScreen>> { NavigationRouterImpl(MainApp.INSTANCE.router) }

}
