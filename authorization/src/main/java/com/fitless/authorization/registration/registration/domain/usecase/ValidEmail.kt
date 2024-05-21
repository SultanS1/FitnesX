package com.fitless.authorization.registration.registration.domain.usecase

/**
 * Validates the email field.
 * @field email The email to be validated.
 * @return True if the email matches the regex pattern, false otherwise.
 */
class ValidEmail {

    operator fun invoke(email: String): String?{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        if(!email.matches(emailRegex.toRegex())){
            return "That is not valid email address"
        }
        if (email.isEmpty()){
            return "Please, write your email address"
        }
        return null
    }

}