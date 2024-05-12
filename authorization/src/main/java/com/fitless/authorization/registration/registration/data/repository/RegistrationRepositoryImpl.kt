package com.fitless.authorization.registration.registration.data.repository

import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository

/**
 * Implementation of the [RegistrationRepository] interface responsible for saving user data.
 */
class RegistrationRepositoryImpl: RegistrationRepository {

    /**
     * Suspended function responsible for saving user data.
     * @param userDataModel The data model containing user data to be saved.
     */
    override suspend fun saveUserData(userDataModel: UserDataModel) {
        TODO("Not yet implemented")
    }

}