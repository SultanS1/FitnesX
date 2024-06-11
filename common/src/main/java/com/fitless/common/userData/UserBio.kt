package com.fitless.common.userData

import kotlinx.serialization.Serializable

@Serializable
data class UserBio(
    val gender: String = "",
    val birthDate: String = "",
    val weight: String = "",
    val weightUnit: String = "",
    val height: String = "",
    val heightUnit: String = ""
)
