package com.example.push.notes.data.model

data class NoteResponse(
    val messageId: Int,
    val userId: Int,
    val adminId: Int?,
    val content: String,
    val response: String?,
    val createdAt: String,
    val respondedAt: String?,
    val status: String
)

