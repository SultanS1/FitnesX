package com.fitless.common.userData

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val name: String? = "",
    val surname: String? = "",
    val email: String? = "",
    val password: String? = "",
    val policy: Boolean? = false
)
