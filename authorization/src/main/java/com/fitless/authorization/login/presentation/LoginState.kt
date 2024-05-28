package com.fitless.authorization.login.presentation

import com.fitless.core.architecture.BaseState

data class LoginState(
    val validationMessage: String = "",
    val loginResponse: LoginResponse,
    val email: String = "",
    val password: String = ""
): BaseState
