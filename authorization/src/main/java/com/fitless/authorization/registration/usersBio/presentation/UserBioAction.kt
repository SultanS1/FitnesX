package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.core.architecture.BaseAction

sealed interface UserBioAction: BaseAction {

    data class ChangeUnit(
        val unit: String
    ): UserBioAction

    data class SubmitBio(
        val gender: String,
        val birthdate: String,
        val weight: String,
        val weightUnit: String,
        val height: String,
        val heightUnit: String
    ): UserBioAction

}