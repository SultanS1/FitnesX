package com.fitless.authorization.registration.registration.domain.model

data class UserDataModel(
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val privacy: Boolean
)
