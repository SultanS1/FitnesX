package com.fitless.authorization.registration.registration.domain.usecase

/**
 * Validates the surname field.
 * @param surname The surname to be validated.
 * @return True if the surname is not empty, false otherwise.
 */
class ValidSurname {

    operator fun invoke(surname: String): String?{
        if(surname.isEmpty()){
            return "Please write your name"
        }
        if (surname.length < 2){
            return "Too short for user name"
        }
        return null
    }

}