package com.fitless.authorization.registration.usersBio.data.repository

import androidx.datastore.core.DataStore
import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel
import com.fitless.authorization.registration.usersBio.domain.repository.UserBioRepository
import com.fitless.common.userData.UserBio

class UserBioRepositoryImpl(
    private val dataStore: DataStore<UserBio>
): UserBioRepository {

    override suspend fun saveUserBio(userBioModel: UserBioModel) {
        dataStore.updateData {
            it.copy(
                gender = userBioModel.gender,
                birthDate = userBioModel.birthDate,
                weight = userBioModel.weight,
                weightUnit = userBioModel.weightUnit,
                height = userBioModel.height,
                heightUnit = userBioModel.heightUnit
            )
        }
    }

}