package com.fitless.authorization.registration.registration.presentation

import com.fitless.core.architecture.BaseSideEffect

sealed interface RegistrationSideEffect: BaseSideEffect {

    data class EmptyFields(val message: String): RegistrationSideEffect

}