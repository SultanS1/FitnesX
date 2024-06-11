package com.fitless.authorization.login.domain.repository

import com.fitless.authorization.login.domain.model.LoginModel

interface LoginRepository {

    suspend fun login(loginModel: LoginModel): Boolean

}