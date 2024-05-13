package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseAction

/**
 * Represents possible actions that can be performed during the registration process.
 */
sealed interface RegistrationAction: BaseAction {

    /**
     * Action to register a user with the provided details.
     * @property name The user's first name.
     * @property surname The user's last name.
     * @property email The user's email address.
     * @property password The user's password.
     * @property policy Indicates whether the user has agreed to the privacy policy.
     * @property registered Indicates whether the user has been successfully registered.
     */
    data class Register(
        val name: String, val surname: String, val email: String,
        val password: String, val policy: Boolean, val registered: Boolean
    ): RegistrationAction

    /**
     * Action to initiate the login process.
     */
    data object Login: RegistrationAction

}