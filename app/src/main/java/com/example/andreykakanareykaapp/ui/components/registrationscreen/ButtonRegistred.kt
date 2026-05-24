package com.example.andreykakanareykaapp.ui.components.registrationscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun ButtonRegistred(
    onClick: () -> Unit, // 1. Добавили параметр для передачи клика наружу
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onClick, // 2. Передали этот клик в стандартную кнопку
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF5A8AD2),
                            0.7f to Color(0xFF263E70)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20.dp)),
            contentPadding = PaddingValues(
                start = 70.dp,
                end = 70.dp,
                top = 24.dp,
                bottom = 24.dp
            ),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ){
            Text(
                text = "Register",
                fontSize = 12.sp,
                fontFamily = kronaOne,
                textAlign = TextAlign.Center,
                color = Color.White // Сделал чуть ярче, но можно вернуть .copy(0.7f)
            )
        }
    }
}

@Preview
@Composable
fun ButtonRegistredPreview(){
    ButtonRegistred(onClick = {})
}