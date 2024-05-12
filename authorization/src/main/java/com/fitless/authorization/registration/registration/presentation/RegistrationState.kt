package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseState

/**
 * Represents the state of the registration screen.
 * @property name The user's first name.
 * @property surname The user's last name.
 * @property email The user's email address.
 * @property password The user's password.
 * @property policy Indicates whether the user has accepted the privacy policy.
 * @property registered Indicates whether the user has successfully registered.
 */
data class RegistrationState(
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val policy: Boolean,
    val registered: Boolean
): BaseState
