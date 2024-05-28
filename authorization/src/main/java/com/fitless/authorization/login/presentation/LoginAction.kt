package com.fitless.authorization.login.presentation

import com.fitless.core.architecture.BaseAction

sealed interface LoginAction: BaseAction {

    data object Submit: LoginAction

    data class SendEmail(val email: String): LoginAction

    data class SendPassword(val password: String): LoginAction

    data object Register: LoginAction

}