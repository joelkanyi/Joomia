package com.kanyideveloper.joomia.feature_auth.domain.model

import com.kanyideveloper.joomia.core.util.Resource

data class LoginResult(
    val passwordError: String? = null,
    val usernameError: String? = null,
    val result: Resource<Unit>? = null
)
