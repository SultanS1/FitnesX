package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseAction

sealed interface RegistrationAction: BaseAction {

    data class Register(
        val name: String, val surname: String, val email: String,
        val password: String, val policy: Boolean, val registered: Boolean
    ): RegistrationAction

    data object Login: RegistrationAction

}