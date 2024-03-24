package com.fitless.fitnessX

import com.fitless.core.RouterProvider
import com.fitless.core.CustomRouter
import com.fitless.fitnessX.application.MyApplication
import com.fitless.fitnessX.router.AppRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.dsl.module

val appModule =  module {

    single { MyApplication.INSTANCE.router }

    single { AppRouter(get()) }

    single<RouterProvider<FragmentScreen>> { object : RouterProvider<FragmentScreen> {
        override fun provideRouter(): CustomRouter<FragmentScreen> {
            return AppRouter(get())
        }
    }}

}
