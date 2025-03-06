package com.example.push.notes.data.repository

import com.example.push.notes.data.datasource.NotesService
import com.example.push.notes.data.model.NoteResponse


class NoteRepository(private val notesService: NotesService) {

    suspend fun getNotes(userId: Int): Result<List<NoteResponse>> {
        return try {
            val response = notesService.getNotes(userId = userId)

            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(response.body()!!)
                } ?: Result.failure(Exception("Response body is null"))
            } else {
                Result.failure(Exception(response.errorBody()?.string() ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
