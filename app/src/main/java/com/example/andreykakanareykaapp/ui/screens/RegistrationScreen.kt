package com.example.andreykakanareykaapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.components.registrationscreen.ButtonRegistred
import com.example.andreykakanareykaapp.ui.components.registrationscreen.RegistrationCurtain


@Composable
fun RegistrationScreen(
    name: String, onNameChange: (String) -> Unit,
    email: String, onEmailChange: (String) -> Unit,
    emailError: String?,
    password: String, onPasswordChange: (String) -> Unit,
    passwordError: String?, // И ЭТУ
    pereatpassword: String, onRepeatPasswordChange: (String) -> Unit,
    repeatPasswordError: String?, // И ЭТУ
    group: String, onGroupChange: (String) -> Unit,
    direction: String, onDirectionChange: (String) -> Unit,
    onRegisterClick: (Boolean) -> Unit
) {
    // Используем только локальные переменные для ошибок
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var repeatPasswordError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2D374A))
    ) {
        Image(
            painter = painterResource(R.drawable.questions),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().padding(start = 10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegistrationCurtain(
                name = name,
                onNameChange = { onNameChange(it) },
                email = email,
                // СБРОС ОШИБКИ ПРИ ВВОДЕ:
                onEmailChange = { onEmailChange(it); emailError = null },
                emailError = emailError,
                password = password,
                onPasswordChange = { onPasswordChange(it); passwordError = null },
                passwordError = passwordError,
                pereatpassword = pereatpassword,
                onRepeatPasswordChange = { onRepeatPasswordChange(it); repeatPasswordError = null },
                repeatPasswordError = repeatPasswordError,
                group = group,
                onGroupChange = onGroupChange,
                direction = direction,
                onDirectionChange = onDirectionChange
            )

            Spacer(Modifier.height(20.dp))

            ButtonRegistred(onClick = {
                var hasError = false

                // ВАЛИДАЦИЯ
                if (!email.contains("@")) {
                    emailError = "Invalid domain"
                    hasError = true
                }
                if (password.length < 6) {
                    passwordError = "Too short"
                    hasError = true
                }
                if (password != pereatpassword) {
                    repeatPasswordError = "Passwords do not match"
                    hasError = true
                }

                if (!hasError) {
                    onRegisterClick(true)
                }
            })
        }
    }
}

// --- ФУНКЦИЯ ДЛЯ ПРОСМОТРА ЭКРАНА В ANDROID STUDIO ---
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    // Создаем фиктивные изменяемые состояния, чтобы превью адекватно рендерилось
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var group by remember { mutableStateOf("") }
    var direction by remember { mutableStateOf("") }

    RegistrationScreen(
        name = name, onNameChange = { name = it },
        email = email, onEmailChange = { email = it },
        emailError = null, // Можно написать "Неверный формат", чтобы потестить вид ошибки
        password = password, onPasswordChange = { password = it },
        passwordError = null,
        pereatpassword = repeatPassword, onRepeatPasswordChange = { repeatPassword = it },
        repeatPasswordError = null,
        group = group, onGroupChange = { group = it },
        direction = direction, onDirectionChange = { direction = it },
        onRegisterClick = {} // Пустое действие для клика в режиме превью
    )
}