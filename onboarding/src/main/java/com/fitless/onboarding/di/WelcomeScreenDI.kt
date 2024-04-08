package com.fitless.onboarding.di


import com.fitless.core.NavigationRouter
import com.fitless.onboarding.onboarding.OnBoardingViewModel
import com.fitless.onboarding.welcomescreen.domain.WelcomePageReducer
import com.fitless.onboarding.welcomescreen.presentation.WelcomeViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val welcomePageModule = module {

    single { WelcomePageReducer(get<NavigationRouter<FragmentScreen>>()) }

    viewModel{ WelcomeViewModel(get()) }
}