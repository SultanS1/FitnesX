package com.fitless.authorization.registration.registration.presentation

import com.fitless.authorization.registration.registration.domain.model.PasswordStatus
import com.fitless.common.validation.EmailStatus
import com.fitless.common.validation.TextStatus
import com.fitless.core.architecture.BaseState

/**
 * Represents the state of the registration screen.
 * @property registered Indicates whether the user has successfully registered.
 */
data class RegistrationState(
    val invalidName: TextStatus = TextStatus.OK,
    val invalidSurname: TextStatus = TextStatus.OK,
    val invalidEmail: EmailStatus = EmailStatus.OK,
    val invalidPassword: PasswordStatus = PasswordStatus.OK,
    val registered: Boolean
): BaseState
