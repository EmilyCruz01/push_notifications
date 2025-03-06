package com.example.push.login.domain

import com.example.push.login.data.model.LoginRequest
import com.example.push.login.data.model.LoginResponse
import com.example.push.login.data.repository.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository ()

    suspend operator fun invoke(loginRequest: LoginRequest): Result<LoginResponse> {
        val result = repository.login(loginRequest)
        return result
    }
}