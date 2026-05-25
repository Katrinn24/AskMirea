package com.example.andreykakanareykaapp.ui.components.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun TopHeader(onProfileClick: () -> Unit) {
    val bottomShape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
    val gradientBrush = Brush.linearGradient(
        0.0f to Color(0xFF3B71B0),
        0.5f to Color(0xFF123262)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(bottomShape) // Обязательно обрезаем весь контент Box
            .background(gradientBrush) // Фон
            .border(width = 1.dp, color = Color.Black, shape = bottomShape) // Рамка
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null // ЭТО УБИРАЕТ КРУГ-ЭФФЕКТ ПРИ НАЖАТИИ
                        ) { onProfileClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_account),
                        contentDescription = null,
                        tint = Color.White // Теперь иконка будет чисто белой, без фона
                    )
                }
                Text(
                    text = "Account",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall,
                    fontFamily = kronaOne
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_rtulogo),
                contentDescription = "University Logo",
                modifier = Modifier.size(100.dp, 100.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewTopHeader() {
    MaterialTheme {
        TopHeader(onProfileClick = {})
    }
}