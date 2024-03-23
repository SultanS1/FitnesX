package com.fitless.onboarding.welcomescreen


import com.fitless.core.AppModuleDependencies
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import com.fitless.onboarding.welcomescreen.presentation.WelcomeViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val welcomePageModule = module {
    single { WelcomePageReducer(get()) }
    single { get<AppModuleDependencies<FragmentScreen>>().provideRouter() }
    viewModel{ WelcomeViewModel(get()) }
}