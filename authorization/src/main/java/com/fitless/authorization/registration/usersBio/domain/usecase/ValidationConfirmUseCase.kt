package com.fitless.authorization.registration.usersBio.domain.usecase

import com.fitless.authorization.registration.usersBio.domain.model.HeightStatus
import com.fitless.authorization.registration.usersBio.domain.model.WeightStatus
import com.fitless.common.validation.TextStatus

class ValidationConfirmUseCase {

    operator fun invoke(
        gender: TextStatus,
        birthdate: TextStatus,
        weight: WeightStatus,
        height: HeightStatus): Boolean{
        return gender == TextStatus.OK
                && birthdate == TextStatus.OK
                && weight == WeightStatus.OK
                && height == HeightStatus.OK
    }

}