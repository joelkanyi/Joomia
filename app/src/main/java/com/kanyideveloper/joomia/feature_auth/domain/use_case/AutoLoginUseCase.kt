package com.kanyideveloper.joomia.feature_auth.domain.use_case

import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.feature_auth.domain.repository.LoginRepository

class AutoLoginUseCase(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(): Resource<Unit> {
        return loginRepository.autoLogin()
    }
}