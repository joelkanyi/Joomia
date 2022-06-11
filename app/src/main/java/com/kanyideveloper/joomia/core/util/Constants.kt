package com.kanyideveloper.joomia.core.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val BASE_URL = "https://fakestoreapi.com/"
    const val SPLASH_SCREEN_DURATION = 3000L
    val AUTH_KEY = stringPreferencesKey(name = "auth_key")
    const val AUTH_PREFERENCES = "AUTH_PREFERENCES"
}