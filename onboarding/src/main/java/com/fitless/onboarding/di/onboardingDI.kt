package com.fitless.onboarding.di

import com.fitless.onboarding.onboarding.presentation.OnBoardingReducer
import com.fitless.onboarding.welcomescreen.presentation.WelcomePageReducer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {

	
	viewModel { WelcomePageReducer(get()) }
	
	viewModel { OnBoardingReducer(get()) }
	
}