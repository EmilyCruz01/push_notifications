package com.example.push.newNote.data.datasource

import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse
import com.google.android.gms.common.api.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NewNoteService {
    @POST("notes") // La URL del endpoint en el backend
    suspend fun newNote(@Body newNoteRequest: NewNoteRequest): Response<NewNoteResponse>
}

