package com.example.push.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.push.login.domain.LoginUseCase
import com.example.push.login.presentation.LoginScreen
import com.example.push.login.presentation.LoginViewModel
import com.example.push.notes.domain.GetNotesUseCase
import com.example.push.notes.presentation.NoteViewModel
import com.example.push.notes.presentation.NotesUI
import com.example.push.register.domain.RegisterUseCase
import com.example.push.register.presentation.RegisterScreen
import com.example.push.register.presentation.RegisterViewModel

@Composable
fun NavigationWrapper () {

    val navController = rememberNavController()
    val loginViewModel = LoginViewModel(LoginUseCase(), {navController.navigate(Register)}, {navController.navigate(Notes)})

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen( loginViewModel)
        }
        composable<Register> {
            RegisterScreen(RegisterViewModel(RegisterUseCase(), {navController.navigate(Login)}))
        }
        composable<Notes> {
            NotesUI(NoteViewModel(GetNotesUseCase(), loginViewModel), {navController.navigate(NewNote)})
        }
        }
    }





