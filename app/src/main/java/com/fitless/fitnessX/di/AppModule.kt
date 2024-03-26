package com.fitless.fitnessX.di

import com.fitless.core.CustomRouter
import com.fitless.fitnessX.application.MainApp
import com.fitless.fitnessX.router.AppRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.dsl.module

val appModule =  module {

    single<CustomRouter<FragmentScreen>> { AppRouter(MainApp.INSTANCE.router) }

}
