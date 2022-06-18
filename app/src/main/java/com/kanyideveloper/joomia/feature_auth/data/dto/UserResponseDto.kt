package com.kanyideveloper.joomia.feature_auth.data.dto


import com.google.gson.annotations.SerializedName

data class UserResponseDto(
    @SerializedName("address")
    val address: Address,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: Name,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("__v")
    val v: Int
)