package com.fitless.authorization.di

import com.fitless.authorization.onboarding.OnboardingPageReducer
import com.fitless.authorization.registration.registration.data.repository.RegistrationRepositoryImpl
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository
import com.fitless.authorization.registration.registration.domain.usecase.ConfirmValidationsUseCase
import com.fitless.authorization.registration.registration.domain.usecase.SaveUserUseCase
import com.fitless.common.validation.ValidEmailUseCase
import com.fitless.common.validation.ValidTextUseCase
import com.fitless.authorization.registration.registration.presentation.RegistrationReducer
import com.fitless.authorization.registration.usersBio.data.repository.UserBioRepositoryImpl
import com.fitless.authorization.registration.usersBio.domain.repository.UserBioRepository
import com.fitless.authorization.registration.usersBio.domain.usecase.SaveUserBioUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidHeightUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidWeightUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidationConfirmUseCase
import com.fitless.authorization.registration.usersBio.presentation.UserBioReducer
import com.fitless.common.userData.DataStoreQualifiers
import com.fitless.common.userData.FileStorage
import com.fitless.common.userData.UserBio
import com.fitless.common.userData.UserData
import com.fitless.common.extensions.userBioDataStore
import com.fitless.common.extensions.userDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val authModule = module {

    //registration
    single(named(DataStoreQualifiers.USER_DATA)){ androidContext().userDataStore }
    single(named(DataStoreQualifiers.USER_DATA)) { FileStorage(get(named(DataStoreQualifiers.USER_DATA)), UserData) }
    single <RegistrationRepository>{ RegistrationRepositoryImpl(get(named(DataStoreQualifiers.USER_DATA))) }
    single { SaveUserUseCase(get()) }
    single { ValidTextUseCase() }
    single { ConfirmValidationsUseCase() }
    single { ValidEmailUseCase() }
    viewModel {
        RegistrationReducer(
            router = get() ,
            validTextUseCase = get(),
            validEmailUseCase = get(),
            confirmValidationsUseCase = get(),
            saveUser = get()
        )
    }

    //user bio
    single(named(DataStoreQualifiers.USER_BIO)){ androidContext().userBioDataStore }
    single(named(DataStoreQualifiers.USER_BIO)) { FileStorage(get(named(DataStoreQualifiers.USER_BIO)), UserBio) }
    single <UserBioRepository>{ UserBioRepositoryImpl(get(named(DataStoreQualifiers.USER_BIO))) }
    single { SaveUserBioUseCase(get()) }
    single { ValidWeightUseCase() }
    single { ValidHeightUseCase() }
    single { ValidationConfirmUseCase() }
    viewModel {
        UserBioReducer(
            router = get(),
            saveUserBioUseCase = get(),
            validGenderUseCase = get(),
            validBirthDateUseCase = get(),
            validWeightUseCase = get(),
            validHeightUseCase = get(),
            validationConfirmUseCase = get()
        )
    }

    //onboarding
    viewModel {
        OnboardingPageReducer(
            router = get()
        )
    }

}

