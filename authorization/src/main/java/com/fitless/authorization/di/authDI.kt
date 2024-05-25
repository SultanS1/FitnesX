package com.fitless.authorization.di

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
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidBirthDate
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidGender
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidHeight
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidWeight
import com.fitless.authorization.registration.usersBio.presentation.UserBioReducer
import com.fitless.common.userData.DataStoreQualifiers
import com.fitless.common.userData.FileStorage
import com.fitless.common.userData.UserBio
import com.fitless.common.userData.UserData
import com.fitless.common.userData.userBioDataStore
import com.fitless.common.userData.userDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.nio.file.FileStore


val authModule = module {

    //registration
    single(named(DataStoreQualifiers.USER_DATA)){ androidContext().userDataStore }
    single { FileStorage(get(named(DataStoreQualifiers.USER_DATA)), UserData) }
    single <RegistrationRepository>{ RegistrationRepositoryImpl(get()) }
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
    single { FileStorage(get(named(DataStoreQualifiers.USER_BIO)), UserBio) }
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

