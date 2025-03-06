package com.example.push.notes.data.datasource

import com.example.push.notes.data.model.NoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface NotesService {
    @GET("notes")
    suspend fun getNotes(userId: Int): Response<List<NoteResponse>>
}