package com.fitless.authorization.registration.usersBio.data.repository

import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel
import com.fitless.authorization.registration.usersBio.domain.repository.UserBioRepository
import com.fitless.common.userData.FileStorage
import com.fitless.common.userData.UserBio

/**
 * Implementation of the [UserBioRepository] interface that uses [FileStorage] to save user bio data.
 *
 * @property dataStore The [FileStorage] instance that manages the user bio data storage.
 */
class UserBioRepositoryImpl(
    private val dataStore: FileStorage<UserBio>
): UserBioRepository {

    /**
     * Suspended function responsible for saving user bio data.
     * This function updates the data stored in [FileStorage] with the provided user bio model.
     *
     * @param userBioModel The data model containing the user bio data to be saved.
     * @throws IOException if there is an error writing to the data store.
     */
    override suspend fun saveUserBio(userBioModel: UserBioModel) {
        dataStore.saveData {
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