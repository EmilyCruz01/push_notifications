package com.example.push.newNote.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.push.login.presentation.LoginViewModel
import kotlinx.coroutines.launch

@Preview
@Composable
fun NewNoteUI(
    newNoteViewModel: NewNoteViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel()
) {
    val noteContent by newNoteViewModel.noteContent.observeAsState("")
    val userId = loginViewModel.userId.observeAsState(-1).value ?: -1


    Column(
        modifier = Modifier
            .background(Color(235, 235, 235))
            .padding(30.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = noteContent,
            onValueChange = { newNoteViewModel.onContentChange(it) },
            placeholder = {
                Text(
                    "Express yourself...",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
               // newNoteViewModel.viewModelScope.launch {
                //    newNoteViewModel.onSubmit(userId)
              //  }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC6F177),
            )
        ) {
            Text(
                text = "Add note",
                color = Color(0xff002c2b),
                fontSize = 20.sp)

        }
    }
}
