package com.fitless.authorization.registration.usersBio.domain.usecase

class ValidWeight {

    operator fun invoke(weight: String): String?{
        if(weight.isEmpty()){
            return "Please enter your weight!"
        }
        if(weight.length == 1){
            return "You are weak, gain some weight and come back)"
        }
        if (weight.length > 3){
            return "App is for human, you are not human"
        }
        return null
    }

}