package com.fitless.onboarding.di


import com.fitless.core.navigation.NavigationRouter
import com.fitless.onboarding.onboarding.presentation.OnBoardingReducer
import com.fitless.onboarding.welcomescreen.presentation.WelcomePageReducer
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val welcomePageModule = module {

    single { get<NavigationRouter<FragmentScreen>>() }

    viewModel { WelcomePageReducer(get()) }

    viewModel { OnBoardingReducer(get())}

}