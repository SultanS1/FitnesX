package com.fitless.authorization.registration.usersBio.domain.usecase

import com.fitless.authorization.registration.usersBio.domain.model.WeightStatus

class ValidWeightUseCase {

    operator fun invoke(weight: String): WeightStatus{

        if(weight.length == 1){
            return WeightStatus.TOO_LIGHT
        }
        if (weight.length > 3){
            return WeightStatus.TOO_HEAVY
        }
        return if(weight.isEmpty()) WeightStatus.EMPTY_FIELD else WeightStatus.OK

    }

}