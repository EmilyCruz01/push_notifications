package com.example.push.newNote.data.repository

import com.example.push.core.network.RetrofitHelper
import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse
import retrofit2.HttpException

class NewNoteRepository {
    private val newNoteService = RetrofitHelper.newNoteService

    suspend fun newNote(request: NewNoteRequest): Result<NewNoteResponse> {
        return try {
            val response = newNoteService.newNote(request)

            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Empty response body"))
            } else {
                Result.failure(HttpException(response))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

