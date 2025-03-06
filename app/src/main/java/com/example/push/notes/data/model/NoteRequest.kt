package com.example.push.notes.data.model

data class NoteRequest(
    val userId: Int,
    val adminId: Int?,
    val content: String,
    val response: String? = null,
    val status: String = "pending"
)

