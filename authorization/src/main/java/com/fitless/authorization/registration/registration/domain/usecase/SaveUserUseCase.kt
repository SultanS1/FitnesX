package com.fitless.authorization.registration.registration.domain.usecase

import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository

class SaveUserUseCase(private val repository: RegistrationRepository) {

    suspend operator fun invoke(userDataModel: UserDataModel) = repository.saveUserData(userDataModel)

}