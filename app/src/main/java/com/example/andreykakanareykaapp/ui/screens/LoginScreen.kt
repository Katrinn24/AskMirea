package com.example.andreykakanareykaapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.components.loginscreen.ButtonLogIn
import com.example.andreykakanareykaapp.ui.components.loginscreen.Curtain
import com.example.andreykakanareykaapp.ui.components.registrationscreen.RegistrationTextField
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2D374A))
    ) {
        Image(
            painter = painterResource(R.drawable.questions),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Используем Column с verticalScroll для прокрутки всего содержимого
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // АВТОМАТИЧЕСКИЙ СКРОЛЛ
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Curtain()

            Column(
                modifier = Modifier
                    .offset(y = (-15).dp)
                    .fillMaxWidth()
                    .padding(horizontal = 45.5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RegistrationTextField(
                    value = email,
                    onValueChange = { email = it; emailError = null },
                    placeholderText = "example@edu.mirea.ru",
                    iconRes = R.drawable.ic_email,
                    isError = emailError != null,
                    errorText = emailError
                )

                Spacer(Modifier.height(16.dp))

                RegistrationTextField(
                    value = password,
                    onValueChange = { password = it; passwordError = null },
                    placeholderText = "Password",
                    iconRes = R.drawable.ic_password,
                    isPassword = true,
                    isError = passwordError != null,
                    errorText = passwordError
                )

                Spacer(Modifier.height(24.dp))

                ButtonLogIn(
                    onClick = {
                        emailError = if (!email.contains("@")) "Invalid domain" else null
                        passwordError = if (password.length < 6) "Too short" else null
                    }
                )
            }

            // "Пружина", которая выталкивает кнопку регистрации вниз,
            // если места на экране достаточно
            Spacer(Modifier.weight(1f))

            TextButton(
                onClick = onNavigateToRegister,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(
                    text = "Not registered?",
                    fontSize = 12.sp,
                    fontFamily = kronaOne,
                    textAlign = TextAlign.Center,
                    color = Color.White.copy(0.7f)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onNavigateToRegister = {})
}