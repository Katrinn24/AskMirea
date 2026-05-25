package com.example.andreykakanareykaapp.ui.components.registrationscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun RegistrationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    @DrawableRes iconRes: Int,
    labelText: String = "",
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorText: String? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    // Убрали padding(horizontal = 45.5.dp) из Column!
    Column(modifier = modifier.fillMaxWidth()) {
        if (labelText.isNotEmpty()) {
            Text(
                text = labelText,
                modifier = Modifier.fillMaxWidth().padding(start = 5.5.dp, bottom = 2.dp),
                color = Color.White,
                fontFamily = kronaOne,
                fontSize = 12.sp,
            )
        }
        Spacer(Modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color(0xFF8CAAD1),
                unfocusedContainerColor = Color(0xFF8CAAD1),
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                // Цвета ошибки
                errorBorderColor = Color(0xFFE57373),
                errorContainerColor = Color(0xFF8CAAD1),
                errorCursorColor = Color(0xFFE57373),
                errorTextColor = Color.White,
                errorPlaceholderColor = Color.White.copy(0.5f)
            ),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            isError = isError,
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            placeholder = {
                Text(
                    text = placeholderText,
                    fontFamily = kronaOne,
                    fontSize = 12.sp,
                    color = Color.White.copy(0.7f),
                )
            },
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(if (passwordVisible) R.drawable.ic_openkey else R.drawable.ic_closedkey),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = if (isError) Color(0xFFE57373) else Color.White.copy(0.4f)
                        )
                    }
                } else {
                    Box(modifier = Modifier.size(48.dp), contentAlignment = Alignment.Center) {
                        Icon(
                            painter = painterResource(iconRes),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = if (isError) Color(0xFFE57373) else Color.White.copy(0.6f)
                        )
                    }
                }
            }
        )

        if (isError && errorText != null) {
            Text(
                text = errorText,
                color = Color(0xFFE57373),
                fontFamily = kronaOne,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 12.dp, top = 4.dp)
            )
        }
    }
}
