package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseState

data class RegistrationState(
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val policy: Boolean,
    val registered: Boolean
): BaseState
