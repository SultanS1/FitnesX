package com.fitless.authorization.registration.registration.domain.usecase

import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository

/**
 * Use case responsible for saving user data.
 * @param repository The repository used to interact with the data layer for saving user data.
 */
class SaveUserUseCase(private val repository: RegistrationRepository) {

    /**
     * Invokes the use case to save user data.
     * @param userDataModel The data model containing user data to be saved.
     */
    suspend operator fun invoke(userDataModel: UserDataModel) = repository.saveUserData(userDataModel)

}