package com.example.andreykakanareykaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import com.example.andreykakanareykaapp.ui.screens.LoginScreen
import com.example.andreykakanareykaapp.ui.screens.RegistrationScreen
import com.example.andreykakanareykaapp.ui.theme.AndreykaKanareykaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndreykaKanareykaAppTheme() {
                var currentScreen by remember { mutableStateOf(AppScreen.Login) }

                // Создаем переменные состояния для полей регистрации здесь
                var name by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var pereatpassword by remember { mutableStateOf("") }
                var group by remember { mutableStateOf("") }
                var direction by remember { mutableStateOf("") }

                var emailError by remember { mutableStateOf<String?>(null) }
                var passwordError by remember { mutableStateOf<String?>(null) }
                var repeatPasswordError by remember { mutableStateOf<String?>(null) }

                when (currentScreen) {
                    AppScreen.Login -> {
                        LoginScreen(
                            onNavigateToRegister = { currentScreen = AppScreen.Registration }
                        )
                    }
                    AppScreen.Registration -> {
                        RegistrationScreen(
                            name = name, onNameChange = { name = it },
                            email = email, onEmailChange = {
                                email = it
                                if (emailError != null) emailError = null
                            },
                            emailError = emailError,
                            password = password, onPasswordChange = {
                                password = it
                                if (passwordError != null) passwordError = null
                            },
                            passwordError = passwordError,
                            pereatpassword = pereatpassword, onRepeatPasswordChange = {
                                pereatpassword = it
                                if (repeatPasswordError != null) repeatPasswordError = null
                            },
                            repeatPasswordError = repeatPasswordError,
                            group = group, onGroupChange = { group = it },
                            direction = direction, onDirectionChange = { direction = it },
                            onRegisterClick = {
                                // Здесь будет логика нажатия, пока оставим пустой или с логом
                                println("Кнопка регистрации нажата!")
                                }
                        )
                    }
                }
            }
        }
    }
}

enum class AppScreen {
    Login,
    Registration
}