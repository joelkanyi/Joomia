package com.kanyideveloper.joomia.feature_profile.presentation.account

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.core.util.UiEvents
import com.kanyideveloper.joomia.destinations.AuthDashboardScreenDestination
import com.kanyideveloper.joomia.feature_auth.data.dto.UserResponseDto
import com.kanyideveloper.joomia.feature_auth.domain.use_case.LogoutUseCase
import com.kanyideveloper.joomia.feature_profile.data.repository.ProfileRepository
import com.kanyideveloper.joomia.feature_profile.data.toDomain
import com.kanyideveloper.joomia.feature_profile.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val logoutUseCase: LogoutUseCase,
    private val gson: Gson,
) : ViewModel() {

    private val _profileState = mutableStateOf(User())
    val profileState: State<User> = _profileState

    fun getProfile() {
        viewModelScope.launch {
            profileRepository.getUserProfile().collectLatest { data ->
                Timber.d("Data: $data")
                val user = gson.fromJson(data, UserResponseDto::class.java)
                _profileState.value = user.toDomain()
            }
        }
    }

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun logout() {
        viewModelScope.launch {
            val result = logoutUseCase()

            Timber.d("Result: ${result.message}")
            when (result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvents.NavigateEvent(route = AuthDashboardScreenDestination.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvents.SnackbarEvent(
                            message = result.message ?: "Unknown error occurred"
                        )
                    )
                }
                else -> {}
            }
        }
    }
}