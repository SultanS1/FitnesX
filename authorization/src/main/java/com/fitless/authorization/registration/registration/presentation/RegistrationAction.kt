package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseAction

/**
 * Represents possible actions that can be performed during the registration process.
 */
sealed interface RegistrationAction: BaseAction {

    /**
     * Action to send name each time when user enters new char
     */
    data class SendName(val name: String): RegistrationAction

    /**
     * Action to send surname each time when user enters new char
     */
    data class SendSurname(val surname: String): RegistrationAction

    /**
     * Action to send email each time when user enters new char
     */
    data class SendEmail(val email: String): RegistrationAction

    /**
     * Action to send password each time when user enters new char
     */
    data class SendPassword(val password: String): RegistrationAction

    /**
     * Action to send state of Policy agreement
     */
    data class SendPolicyState(val policy: Boolean): RegistrationAction

    /**
     * Action to register a user with the provided details.
     */
    data object Register: RegistrationAction

    /**
     * Action to initiate the login process.
     */
    data object Login: RegistrationAction

}