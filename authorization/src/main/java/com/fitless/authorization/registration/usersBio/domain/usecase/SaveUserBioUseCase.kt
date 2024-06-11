package com.fitless.authorization.registration.usersBio.domain.usecase

import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel
import com.fitless.authorization.registration.usersBio.domain.repository.UserBioRepository

class SaveUserBioUseCase(private val repository: UserBioRepository) {

    suspend operator fun invoke(userBioModel: UserBioModel) = repository.saveUserBio(userBioModel)


}