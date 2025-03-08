package com.example.push.newNote.domain

import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse
import com.example.push.newNote.data.repository.NewNoteRepository

class NewNoteUseCase {
    private val repository = NewNoteRepository()

    suspend operator fun invoke(newNoteRequest: NewNoteRequest): Result<NewNoteResponse> {
        val result = repository.newNote(newNoteRequest)
        return result
    }
}