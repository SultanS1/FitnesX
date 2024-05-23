package com.fitless.authorization.registration.usersBio.domain.repository

import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel

interface UserBioRepository {

    suspend fun saveUserBio(userBioModel: UserBioModel)

}