package com.kanyideveloper.joomia.feature_auth.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.feature_auth.domain.use_case.AutoLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val autoLoginUseCase: AutoLoginUseCase) :
    ViewModel() {

    private val _eventState = mutableStateOf(false)
    val eventState: State<Boolean> = _eventState

    init {
        autoLoginUser()
    }

    private fun autoLoginUser() {
        viewModelScope.launch {
            when (autoLoginUseCase()) {
                is Resource.Success -> {
                    _eventState.value = true
                }
                is Resource.Error -> {
                    _eventState.value = false
                }
                else -> {}
            }
        }
    }
}