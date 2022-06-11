package com.kanyideveloper.joomia.feature_auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanyideveloper.joomia.core.domain.model.TextFieldState
import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.core.util.UiEvents
import com.kanyideveloper.joomia.destinations.HomeScreenDestination
import com.kanyideveloper.joomia.feature_auth.domain.use_case.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _usernameState = mutableStateOf(TextFieldState())
    val usernameState: State<TextFieldState> = _usernameState
    fun setUsername(value: String) {
        _usernameState.value = usernameState.value.copy(text = value)
    }

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState
    fun setPassword(value: String) {
        _passwordState.value = _passwordState.value.copy(text = value)
    }

    private val _rememberMeState = mutableStateOf(false)
    val rememberMeState: State<Boolean> = _rememberMeState
    fun setRememberMe(value: Boolean) {
        _rememberMeState.value = value
    }

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun loginUser() {
        viewModelScope.launch {
            _loginState.value = loginState.value.copy(isLoading = true)

            val loginResult = loginUseCase(
                username = usernameState.value.text,
                password = passwordState.value.text,
                rememberMe = rememberMeState.value
            )

            _loginState.value = loginState.value.copy(isLoading = false)

            if (loginResult.usernameError != null) {
                _usernameState.value = usernameState.value.copy(error = loginResult.usernameError)
            }

            if (loginResult.passwordError != null) {
                _passwordState.value = passwordState.value.copy(error = loginResult.passwordError)
            }

            when (loginResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvents.NavigateEvent(HomeScreenDestination.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvents.SnackbarEvent(
                            loginResult.result.message ?: "Unknown error occurred!"
                        )
                    )
                }
                else -> {}
            }
        }
    }
}