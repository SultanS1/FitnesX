package com.fitless.authorization.registration.registration.domain.repository

import com.fitless.authorization.registration.registration.domain.model.UserDataModel

interface RegistrationRepository {

    suspend fun saveUserData(userDataModel: UserDataModel)

}