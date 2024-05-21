package com.fitless.authorization.registration.registration.domain.usecase

/**
 * Validates the password field.
 * @param password The password to be validated.
 * @return True if the password length is greater than 3 characters, false otherwise.
 */
class ValidPassword {

    operator fun invoke(password: String): String?{
        if(password.length < 6){
            return "Password should consist at least 6 character"
        }
        return null
    }

}