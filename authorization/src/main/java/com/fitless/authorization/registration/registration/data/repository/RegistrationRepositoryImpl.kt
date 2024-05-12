package com.fitless.authorization.registration.registration.data.repository

import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository

class RegistrationRepositoryImpl: RegistrationRepository {

    override suspend fun saveUserData(userDataModel: UserDataModel) {
        TODO("Not yet implemented")
    }

}