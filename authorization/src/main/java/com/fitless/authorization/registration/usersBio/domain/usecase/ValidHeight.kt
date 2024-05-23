package com.fitless.authorization.registration.usersBio.domain.usecase

class ValidHeight {

    operator fun invoke(height: String): String?{
        if(height.isEmpty()){
            return "Please enter your height!"
        }
        if (height.length == 1){
            return "You can't be that small, please enter your actual height!"
        }
        if(height.length > 3){
            return "You are not human, this app is not for you!"
        }
        return null
    }

}