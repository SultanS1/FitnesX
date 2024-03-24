package com.fitless.onboarding.di


import com.fitless.core.RouterProvider
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import com.fitless.onboarding.welcomescreen.presentation.WelcomeViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val welcomePageModule = module {

    single { WelcomePageReducer(get()) }

    single { get<RouterProvider<FragmentScreen>>().provideRouter() }

    viewModel{ WelcomeViewModel(get()) }

}