package com.example.push.notes.domain

import com.example.push.notes.data.model.NoteResponse
import com.example.push.notes.data.repository.NoteRepository

class GetNotesUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(userId: Int): Result<List<NoteResponse>> {
        return repository.getNotes(userId)
    }
}
