package com.example.push.core.network

import com.example.push.login.data.datasource.LoginService
import com.example.push.newNote.data.datasource.NewNoteService
import com.example.push.notes.data.datasource.NotesService
import com.example.push.register.data.datasource.RegisterService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {


    private const val BASE_URL = " "


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
            .build()
    }

    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }

    val registerService: RegisterService by lazy {
        retrofit.create(RegisterService::class.java)
    }

    val newNoteService: NewNoteService by lazy {
        retrofit.create(NewNoteService::class.java)
    }

    val notesService: NotesService by lazy {
        retrofit.create(NotesService::class.java)
    }


}