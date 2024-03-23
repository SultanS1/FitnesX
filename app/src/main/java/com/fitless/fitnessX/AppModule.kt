package com.fitless.fitnessX

import com.fitless.core.AppModuleDependencies
import com.fitless.fitnessX.application.MyApplication
import com.fitless.fitnessX.router.AppRouter
import com.fitless.fitnessX.router.AppRouterProvider
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.dsl.module

val appModule =  module {
    single { MyApplication.INSTANCE.router }
    single { AppRouter(get()) }
    single<AppModuleDependencies<FragmentScreen>> { AppRouterProvider(get()) }
}
