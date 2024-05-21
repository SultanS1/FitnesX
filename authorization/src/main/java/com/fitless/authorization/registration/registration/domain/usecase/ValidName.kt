package com.fitless.authorization.registration.registration.domain.usecase

/**
 * Validates the name field.
 * @param name The name to be validated.
 * @return True if the name is not empty, false otherwise.
 */
class ValidName {

    operator fun invoke(name: String): String?{
        if(name.isEmpty()){
            return "Please write your name"
        }
        if (name.length < 2){
            return "Too short for user name"
        }
        return null
    }

}