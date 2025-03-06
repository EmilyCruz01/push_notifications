package com.example.push.notes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.push.notes.data.model.NoteResponse
import com.example.push.notes.domain.GetNotesUseCase
import kotlinx.coroutines.launch


class NoteViewModel(private val getNotesUseCase: GetNotesUseCase) : ViewModel() {

    private val _notes = MutableLiveData<List<NoteResponse>>()
    val notes: LiveData<List<NoteResponse>> = _notes

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchNotes(userId: Int) {
        viewModelScope.launch {
            val result = getNotesUseCase(userId)
            result.onSuccess { _notes.value = it }
            result.onFailure { e -> _error.value = e.message ?: "Unknown error" }
        }
    }
}
