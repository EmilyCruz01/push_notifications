package com.example.push.newNote.data.model

data class NewNoteResponse(
    val messageId: Int,
    val userId: Int,
    val adminId: Int?,
    val content: String,
    val response: String?,
    val createdAt: String,
    val respondedAt: String?,
    val status: String
)

