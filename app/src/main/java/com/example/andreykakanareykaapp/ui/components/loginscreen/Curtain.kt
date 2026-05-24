package com.example.andreykakanareykaapp.ui.components.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun Curtain() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp) // Увеличили высоту шторки до 500.dp, чтобы дать простор снизу!
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
        // Внутренняя полупрозрачная карточка
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                // Увеличили bottom с 40.dp до 75.dp — теперь снизу будет красивый синий отступ
                .padding(start = 45.5.dp, top = 75.dp, end = 45.5.dp, bottom = 75.dp)
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(50.dp))
                .background(
                    color = Color.White.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(R.drawable.ic_rtulogo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.weight(1.2f))

                Text(
                    text = "AskMirea",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), // Чуть уменьшили внутренний паддинг текста, так как карточка приподнялась
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontFamily = kronaOne,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun CurtainPreview() {
    Curtain()
}