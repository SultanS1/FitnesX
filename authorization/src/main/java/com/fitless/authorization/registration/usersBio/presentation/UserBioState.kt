package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.authorization.registration.usersBio.domain.model.HeightStatus
import com.fitless.authorization.registration.usersBio.domain.model.WeightStatus
import com.fitless.common.validation.TextStatus
import com.fitless.core.architecture.BaseState

data class UserBioState(
    val weightUnit: WeightUnit = WeightUnit.KG,
    val heightUnit: HeightUnit = HeightUnit.CM,
    val genderEmpty: TextStatus = TextStatus.OK,
    val birthdateEmpty: TextStatus = TextStatus.OK,
    val weightEmpty: WeightStatus = WeightStatus.OK,
    val heightEmpty: HeightStatus = HeightStatus.OK,
    val gender: String = "",
    val birthdate: String = "",
    val weight: String = "",
    val height: String = ""
): BaseState
