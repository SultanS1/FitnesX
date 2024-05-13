package com.fitless.authorization.di

import com.fitless.authorization.registration.registration.presentation.RegistrationReducer
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    viewModel { RegistrationReducer(get()) }

}