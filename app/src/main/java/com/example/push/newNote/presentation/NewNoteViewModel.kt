package com.example.push.newNote.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.push.login.presentation.LoginViewModel
import com.example.push.newNote.data.model.NewNoteRequest
import com.example.push.newNote.data.model.NewNoteResponse
import com.example.push.newNote.domain.NewNoteUseCase

class NewNoteViewModel(private val newNoteUseCase: NewNoteUseCase, private val loginViewModel: LoginViewModel, private val navigateToHome: () -> Unit, private val context: Context) : ViewModel() {

    private val _noteContent = MutableLiveData<String>("")
    val noteContent: LiveData<String> get() = _noteContent

    private val _noteResponse = MutableLiveData<Result<NewNoteResponse>?>()
    val noteResponse: LiveData<Result<NewNoteResponse>?> get() = _noteResponse

    fun onContentChange(content: String) {
        _noteContent.value = content
    }
    suspend fun onSubmit(userId: Int) {
        Log.d("USERID", userId.toString())

        val content = noteContent.value ?: ""  // Evitar valores nulos
        val request = NewNoteRequest(userId = userId, content = content)

        val result = newNoteUseCase(request)

        Log.d("API", result.toString())

        result.onSuccess {
            navigateToHome()
        }
    }

}
