package com.fitless.fitnessX.application

import android.app.Application
import com.fitless.fitnessX.appModule
import com.fitless.onboarding.welcomescreen.welcomePageModule
import com.github.terrakok.cicerone.Cicerone
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
class MyApplication : Application(){

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, welcomePageModule)
        }
    }

    companion object {
        internal lateinit var INSTANCE: MyApplication
            private set
    }
}
