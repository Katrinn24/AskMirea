package com.example.andreykakanareykaapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class RegistrationViewModel : ViewModel() {
    var name by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var repeatPassword by mutableStateOf("")
        private set
    var group by mutableStateOf("")
        private set
    var direction by mutableStateOf("")
        private set

    var emailError by mutableStateOf<String?>(null)
        private set
    var passwordError by mutableStateOf<String?>(null)
        private set
    var repeatPasswordError by mutableStateOf<String?>(null)
        private set
    var isLoading by mutableStateOf(value = false)
        private set

    fun updateName(newValue: String) {
        name = newValue
    }

    fun updateEmail(newValue: String) {
        email = newValue; emailError = null
    }

    fun updatePassword(newValue: String) {
        password = newValue; passwordError = null
    }

    fun updateRepeatPassword(newValue: String) {
        repeatPassword = newValue; repeatPasswordError = null
    }

    fun updateGroup(newValue: String) {
        group = newValue
    }

    fun updateDirection(newValue: String) {
        direction = newValue
    }

    fun register(onSuccess: () -> Unit) {
        var hasError = false

        if (!email.contains("@")) {
            emailError = "Invalid domain"
            hasError = true
        }
        if (password.length < 6) {
            passwordError = "Too short (min 6 chars)"
            hasError = true
        }
        if (password != repeatPassword) {
            repeatPasswordError = "Passwords do not match"
            hasError = true
        }

        if (!hasError) {
            isLoading = true
            viewModelScope.launch {
                try {
                    // 1. Создаем пользователя в Firebase Auth
                    val authResult =
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                            .await()
                    val userId = authResult.user?.uid

                    if (userId != null) {
                        // 2. Собираем введенные данные в "словарь"
                        val userData = hashMapOf(
                            "name" to name,
                            "email" to email,
                            "group" to group,
                            "direction" to direction,
                        )

                        // 3. Сохраняем данные в коллекцию "users", где ID документа = ID пользователя
                        FirebaseFirestore.getInstance().collection("users").document(userId)
                            .set(userData).await()
                    }

                    // Успешная регистрация и переход на MainScreen
                    onSuccess()
                } catch (e: Exception) {
                    // Если почта уже занята или нет интернета — покажем ошибку
                    emailError = e.localizedMessage
                } finally {
                    isLoading = false
                }
            }
        }
    }
}