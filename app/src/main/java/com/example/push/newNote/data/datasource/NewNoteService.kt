package com.example.push.newNote.data.datasource

import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NewNoteService {
    @POST("notes")
    suspend fun newNote(@Body request: NewNoteRequest): Response<NewNoteResponse>
}

