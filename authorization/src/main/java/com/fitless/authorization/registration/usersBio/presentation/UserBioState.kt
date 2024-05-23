package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.core.architecture.BaseState

data class UserBioState(
    val weightUnit: String,
    val heightUnit: String,
    val genderEmpty: String? = null,
    val birthdateEmpty: String? = null,
    val weightEmpty: String? = null,
    val heightEmpty: String? = null,
): BaseState
