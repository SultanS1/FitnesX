package com.fitless.authorization.login.data.repository

import com.fitless.authorization.login.domain.model.LoginModel
import com.fitless.authorization.login.domain.repository.LoginRepository
import com.fitless.common.userData.FileStorage
import com.fitless.common.userData.UserData
import kotlinx.coroutines.flow.first

class LoginRepositoryImpl(
    private val dataStore: FileStorage<UserData>
): LoginRepository {

    override suspend fun login(loginModel: LoginModel): Boolean {
        val user = dataStore.data.first()
        return loginModel.email == user.email && loginModel.password == user.password
    }

}