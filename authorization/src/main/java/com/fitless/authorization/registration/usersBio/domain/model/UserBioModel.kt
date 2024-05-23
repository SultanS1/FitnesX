package com.fitless.authorization.registration.usersBio.domain.model

data class UserBioModel(
    val gender: String,
    val birthDate: String,
    val weight: String,
    val weightUnit: String,
    val height: String,
    val heightUnit: String
)
