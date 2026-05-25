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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.presentation.RegistrationViewModel
import com.example.andreykakanareykaapp.ui.components.registrationscreen.ButtonRegistred
import com.example.andreykakanareykaapp.ui.components.registrationscreen.RegistrationCurtain

@Composable
fun RegistrationScreen(
    onRegisterSuccess: () -> Unit,
    viewModel: RegistrationViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2D374A))
    ) {
        Image(
            painter = painterResource(R.drawable.questions),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegistrationCurtain(
                name = viewModel.name,
                onNameChange = viewModel::updateName,
                email = viewModel.email,
                onEmailChange = viewModel::updateEmail,
                emailError = viewModel.emailError,
                password = viewModel.password,
                onPasswordChange = viewModel::updatePassword,
                passwordError = viewModel.passwordError,
                repeatPassword = viewModel.repeatPassword,
                onRepeatPasswordChange = viewModel::updateRepeatPassword,
                repeatPasswordError = viewModel.repeatPasswordError,
                group = viewModel.group,
                onGroupChange = viewModel::updateGroup,
                direction = viewModel.direction,
                onDirectionChange = viewModel::updateDirection
            )

            Spacer(Modifier.height(20.dp))

            ButtonRegistred(
                onClick = {
                    viewModel.register(onSuccess = onRegisterSuccess)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen(onRegisterSuccess = {})
}