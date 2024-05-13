package com.fitless.authorization.registration.registration.domain.repository

import com.fitless.authorization.registration.registration.domain.model.UserDataModel

/**
 * Interface representing a repository for handling user registration-related data operations.
 */
interface RegistrationRepository {

    /**
     * Saves user data to the repository.
     * @param userDataModel The data model containing user registration information to be saved.
     */
    suspend fun saveUserData(userDataModel: UserDataModel)

}