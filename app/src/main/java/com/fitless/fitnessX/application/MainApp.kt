package com.fitless.fitnessX.application

import android.app.Application
import com.fitless.authorization.di.authModule
import com.fitless.fitnessX.di.appModule
import com.fitless.onboarding.di.onboardingModule
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application(){

    private val cicerone = Cicerone.create()

    val router get() = cicerone.router

    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@MainApp)
            modules(appModule, onboardingModule, authModule)
        }
    }

    companion object {
        internal lateinit var INSTANCE: MainApp
            private set
    }

}
