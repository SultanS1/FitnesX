package com.fitless.authorization.registration.usersBio.domain.usecase

import com.fitless.authorization.registration.usersBio.domain.model.HeightStatus

class ValidHeightUseCase {

    operator fun invoke(height: String): HeightStatus{
        if (height.length == 1){
            return HeightStatus.DWARF
        }
        if(height.length > 3){
            return HeightStatus.TOO_HIGH
        }
        return if(height.isEmpty()) HeightStatus.EMPTY_FIELD else HeightStatus.OK
    }

}