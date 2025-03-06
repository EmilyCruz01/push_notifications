package com.example.push.newNote.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewNoteViewModel {
    private val _note= MutableLiveData<String>()

    val note: LiveData<String> = _note

    fun onChangeNote(note:String){
        _note.value= note
    }


}