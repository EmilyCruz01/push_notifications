package com.example.push.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.push.login.data.model.LoginRequest
import com.example.push.login.domain.LoginUseCase
import kotlinx.coroutines.launch

import com.example.push.register.presentation.RegisterScreen

class LoginViewModel(private val loginUseCase: LoginUseCase, private val navigateToHome: () -> Unit, private val navigateToRegister: () -> Unit) : ViewModel() {
    private val _email = MutableLiveData("")
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> get() = _password

    private val _isSuccess = MutableLiveData<Boolean?>()
    val isSuccess: LiveData<Boolean?> get() = _isSuccess

    fun onChangeEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun onChangePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun onSubmit() {
        viewModelScope.launch {
            val result = loginUseCase(LoginRequest(email.value ?: "", password.value ?: ""))
            result.onSuccess {
                _isSuccess.value = true
                navigateToHome()
            }
            result.onFailure {
                _isSuccess.value = false
            }
        }
    }

    fun navigateToRegister() {
        navigateToRegister()
    }
}