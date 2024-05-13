package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseSideEffect

/**
 * Represents possible side effects during the registration process.
 */
sealed interface RegistrationSideEffect: BaseSideEffect {

    /**
     * Indicates that there are empty fields in the registration form.
     * @property message A message describing the empty fields.
     */
    data class EmptyFields(val message: String): RegistrationSideEffect

}