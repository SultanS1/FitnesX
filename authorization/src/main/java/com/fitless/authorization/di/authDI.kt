package com.fitless.authorization.di

import androidx.datastore.core.DataStore
import com.fitless.authorization.registration.registration.data.repository.RegistrationRepositoryImpl
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository
import com.fitless.authorization.registration.registration.domain.usecase.SaveUserUseCase
import com.fitless.authorization.registration.registration.domain.usecase.ValidEmail
import com.fitless.authorization.registration.registration.domain.usecase.ValidName
import com.fitless.authorization.registration.registration.domain.usecase.ValidPassword
import com.fitless.authorization.registration.registration.domain.usecase.ValidSurname
import com.fitless.authorization.registration.registration.presentation.RegistrationReducer
import com.fitless.authorization.registration.usersBio.data.repository.UserBioRepositoryImpl
import com.fitless.authorization.registration.usersBio.domain.repository.UserBioRepository
import com.fitless.authorization.registration.usersBio.domain.usecase.SaveUserBioUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidBirthDate
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidGender
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidHeight
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidWeight
import com.fitless.authorization.registration.usersBio.presentation.UserBioReducer
import com.fitless.common.userData.UserBio
import com.fitless.common.userData.UserData
import com.fitless.common.userData.userBioDataStore
import com.fitless.common.userData.userDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val authModule = module {

    //registration
    single <DataStore<UserData>>{ androidContext().userDataStore }
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

    //user bio
    single <DataStore<UserBio>>{ androidContext().userBioDataStore }
    single <UserBioRepository>{ UserBioRepositoryImpl(get()) }
    single { SaveUserBioUseCase(get()) }
    single { ValidGender() }
    single { ValidBirthDate() }
    single { ValidWeight() }
    single { ValidHeight() }
    viewModel {
        UserBioReducer(
            router = get(),
            saveUserBio = get(),
            validGender = get(),
            validBirthDate = get(),
            validWeight = get(),
            validHeight = get()
        )
    }

}

