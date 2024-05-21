package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseState

/**
 * Represents the state of the registration screen.
 * @property registered Indicates whether the user has successfully registered.
 */
data class RegistrationState(
    val invalidName: String? = null,
    val invalidSurname: String? = null,
    val invalidEmail: String? = null,
    val invalidPassword: String? = null,
    val registered: Boolean
): BaseState
