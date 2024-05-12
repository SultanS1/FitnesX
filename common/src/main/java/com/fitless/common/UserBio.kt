package com.fitless.common

import kotlinx.serialization.Serializable

@Serializable
data class UserBio(
    val gender: String,
    val birthDate: String,
    val weight: String,
    val height: String
)
