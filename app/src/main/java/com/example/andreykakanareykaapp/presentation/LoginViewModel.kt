package com.example.andreykakanareykaapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var emailError by mutableStateOf<String?>(null)
        private set
    var passwordError by mutableStateOf<String?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun updateEmail(newValue: String) {
        email = newValue
        emailError = null
    }

    fun updatePassword(newValue: String) {
        password = newValue
        passwordError = null
    }

    fun login(onSuccess: () -> Unit) {
        emailError = if (!email.contains("@")) "Invalid domain" else null
        passwordError = if (password.length < 6) "Too short" else null

        if (emailError == null && passwordError == null) {
            isLoading = true
            viewModelScope.launch {
                try {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
                    onSuccess()
                } catch (e: Exception) {
                    emailError = e.localizedMessage
                } finally {
                    isLoading = false
                }
            }
        }
    }
}