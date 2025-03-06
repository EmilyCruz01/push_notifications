package com.example.push.login.data.repository

import com.example.push.core.network.RetrofitHelper
import com.example.push.login.data.model.LoginRequest
import com.example.push.login.data.model.LoginResponse


class LoginRepository {
    private val loginService = RetrofitHelper.loginService

    suspend fun login (request : LoginRequest): kotlin.Result<LoginResponse> {
        return try {
            val response = loginService.login(request)

            if(response.isSuccessful){
                kotlin.Result.success(response.body()!!)
            } else {
                kotlin.Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            kotlin.Result.failure(e)
        }
    }
}