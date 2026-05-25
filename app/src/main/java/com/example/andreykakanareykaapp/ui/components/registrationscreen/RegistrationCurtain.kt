package com.example.andreykakanareykaapp.ui.components.registrationscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun RegistrationCurtain(
    name: String, onNameChange: (String) -> Unit,
    email: String, onEmailChange: (String) -> Unit,
    emailError: String?, // Должен быть здесь
    password: String, onPasswordChange: (String) -> Unit,
    passwordError: String?, // Должен быть здесь
    repeatPassword: String, onRepeatPasswordChange: (String) -> Unit,
    repeatPasswordError: String?, // Должен быть здесь
    group: String, onGroupChange: (String) -> Unit,
    direction: String, onDirectionChange: (String) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp)
            )
            .background(
                brush = Brush.linearGradient(
                    colorStops = arrayOf(
                        0.0f to Color(0xFF3B71B0),
                        0.6f to Color(0xFF123262)
                    )
                ),
                shape = RoundedCornerShape(bottomEnd = 50.dp, bottomStart = 50.dp),
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 45.5.dp)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                text = "AskMirea",
                color = Color.White,
                fontFamily = kronaOne,
                fontSize = 42.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 41.dp),
                text = "registration",
                color = Color.White,
                fontFamily = kronaOne,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            // 1. Имя
            RegistrationTextField(
                value = name,
                onValueChange = onNameChange,
                labelText = "Last Name First Name",
                placeholderText = "Your name",
                iconRes = R.drawable.ic_user,
            )
            Spacer(Modifier.height(22.dp))

            // 2. Email
            RegistrationTextField(
                value = email,
                onValueChange = onEmailChange,
                placeholderText = "example@gmail.com",
                labelText = "Email",
                iconRes = R.drawable.ic_email,
                isError = emailError != null,
                errorText = emailError
            )
            Spacer(Modifier.height(22.dp))

            // 3. Пароль
            RegistrationTextField(
                value = password,
                onValueChange = onPasswordChange,
                placeholderText = "Password",
                labelText = "Password",
                iconRes = R.drawable.ic_password,
                isPassword = true,
                isError = passwordError != null,
                errorText = passwordError
            )
            Spacer(Modifier.height(18.dp))

            // 4. Повтор пароля (теперь со своей ошибкой repeatPasswordError)
            RegistrationTextField(
                value = repeatPassword,
                onValueChange = onRepeatPasswordChange,
                placeholderText = "Repeat the password",
                iconRes = R.drawable.ic_password,
                isPassword = true,
                isError = repeatPasswordError != null,
                errorText = repeatPasswordError
            )
            Spacer(Modifier.height(22.dp))

            // 5. Группа
            RegistrationTextField(
                value = group,
                onValueChange = onGroupChange,
                placeholderText = "Group (IKBO-13-25)",
                labelText = "Group",
                iconRes = R.drawable.ic_group,
            )
            Spacer(Modifier.height(22.dp))

            // 6. Направление
            RegistrationTextField(
                value = direction,
                onValueChange = onDirectionChange,
                placeholderText = "Direction (IIT)",
                labelText = "Direction",
                iconRes = R.drawable.ic_direction,
            )
            Spacer(Modifier.height(44.dp))
        }
    }
}


