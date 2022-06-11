package com.kanyideveloper.joomia.feature_auth.data.remote.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String
)