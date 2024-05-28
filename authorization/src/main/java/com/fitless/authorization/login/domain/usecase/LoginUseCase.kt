package com.fitless.authorization.login.domain.usecase

import com.fitless.authorization.login.domain.model.LoginModel
import com.fitless.authorization.login.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {

    suspend operator fun invoke(loginModel: LoginModel): Boolean = loginRepository.login(loginModel)

}