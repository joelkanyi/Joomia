package com.kanyideveloper.joomia.feature_profile.data.repository

import com.google.gson.Gson
import com.kanyideveloper.joomia.feature_auth.data.dto.UserResponseDto
import com.kanyideveloper.joomia.feature_auth.data.local.AuthPreferences
import com.kanyideveloper.joomia.feature_profile.data.toDomain
import com.kanyideveloper.joomia.feature_profile.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import timber.log.Timber

class ProfileRepository(private val authPreferences: AuthPreferences) {
    fun getUserProfile(): Flow<String> {
        return authPreferences.getUserData
    }
}