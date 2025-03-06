package com.example.push.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.push.login.domain.LoginUseCase
import com.example.push.login.presentation.LoginViewModel

@Composable
fun NavigationWrapper () {

    val navController = rememberNavController()
    val loginViewModel = LoginViewModel(LoginUseCase(), {navController.navigate(Register)})

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen( loginViewModel)
        }
        composable<Register> {
            RegisterScreen(RegisterViewModel(RegisterUseCase(), {navController.navigate(Login)}))
        }

    }
}




