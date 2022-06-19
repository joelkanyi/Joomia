package com.kanyideveloper.joomia.feature_profile.data.repository

import com.google.gson.Gson
import com.kanyideveloper.joomia.feature_auth.data.dto.UserResponseDto
import com.kanyideveloper.joomia.feature_auth.data.local.AuthPreferences
import com.kanyideveloper.joomia.feature_profile.data.toDomain
import com.kanyideveloper.joomia.feature_profile.domain.model.User
import kotlinx.coroutines.flow.first

class ProfileRepository(
    private val authPreferences: AuthPreferences,
    private val gson: Gson
) {
    suspend fun getUserProfile() : User{
        val data = authPreferences.getUserData.first()
        val user = gson.fromJson(data, UserResponseDto::class.java)
        return user.toDomain()
    }
}