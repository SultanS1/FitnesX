package com.fitless.common.validation

/**
 * Validates the email field.
 * @field email The email to be validated.
 * @return True if the email matches the regex pattern, false otherwise.
 */
class ValidEmailUseCase {

    operator fun invoke(email: String): EmailStatus {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        if(!email.matches(emailRegex.toRegex())){
            return EmailStatus.INVALID_EMAIL_ADDRESS
        }
        return if (email.isEmpty()) EmailStatus.EMPTY_EMAIL_ADDRESS else EmailStatus.OK
    }

}