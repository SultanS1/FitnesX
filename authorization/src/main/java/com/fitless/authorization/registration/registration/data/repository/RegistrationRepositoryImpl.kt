package com.fitless.authorization.registration.registration.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.repository.RegistrationRepository
import com.fitless.common.userData.UserData
import kotlinx.coroutines.flow.first

/**
 * Implementation of the [RegistrationRepository] interface responsible for saving user data.
 */
class RegistrationRepositoryImpl(private val dataStore: DataStore<UserData>): RegistrationRepository {
    /**
     * Suspended function responsible for saving user data.
     * @param userDataModel The data model containing user data to be saved.
     */
    override suspend fun saveUserData(userDataModel: UserDataModel) {
        dataStore.updateData {
            it.copy(
                name = userDataModel.name,
                surname = userDataModel.surname,
                email = userDataModel.email,
                password = userDataModel.password,
                policy = userDataModel.policy
            )
        }
    }

}