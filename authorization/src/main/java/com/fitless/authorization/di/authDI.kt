package com.fitless.authorization.di

import com.fitless.authorization.registration.registration.data.repository.RegistrationRepositoryImpl
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository
import com.fitless.authorization.registration.registration.domain.usecase.SaveUserUseCase
import com.fitless.authorization.registration.registration.domain.usecase.ValidEmail
import com.fitless.authorization.registration.registration.domain.usecase.ValidName
import com.fitless.authorization.registration.registration.domain.usecase.ValidPassword
import com.fitless.authorization.registration.registration.domain.usecase.ValidSurname
import com.fitless.authorization.registration.registration.presentation.RegistrationReducer
import com.fitless.common.userDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val authModule = module {

    //registration
    single { androidContext().userDataStore }
    single <RegistrationRepository>{ RegistrationRepositoryImpl(get()) }
    single { SaveUserUseCase(get()) }
    single { ValidName() }
    single { ValidSurname() }
    single { ValidEmail() }
    single { ValidPassword() }
    viewModel {
        RegistrationReducer(
            router = get() ,
            validName = get(),
            validSurname = get(),
            validEmail = get(),
            validPassword = get(),
            saveUser = get()
        )
    }

}

