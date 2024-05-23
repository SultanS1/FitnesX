package com.fitless.authorization.registration.usersBio.domain.usecase

class ValidBirthDate {

    operator fun invoke(date: String): String?{
        if(date.isEmpty()){
            return "Please, choose your date of birth"
        }
        return null
    }

}