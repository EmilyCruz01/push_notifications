package com.example.push.newNote.data.repository

import com.example.push.core.network.RetrofitHelper
import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse

class NewNoteRepository{
private val newNoteService = RetrofitHelper.newNoteService

    suspend fun newNote(request: NewNoteRequest): Result<NewNoteResponse> {
        return try {
            val response = newNoteService.newNote(request)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
