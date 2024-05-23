package com.fitless.authorization.registration.usersBio.domain.usecase

class ValidGender {

    operator fun invoke(gender: String): String?{
        if(gender.isEmpty()){
            return "Please, choose gender which you belong to!"
        }
        return null
    }

}