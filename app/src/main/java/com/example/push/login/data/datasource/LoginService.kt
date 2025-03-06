package com.example.push.login.data.datasource

import com.example.push.login.data.model.LoginRequest
import com.example.push.login.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService{
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}