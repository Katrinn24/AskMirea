package com.example.andreykakanareykaapp.ui.components.mainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.data.QuestionItem
import com.example.andreykakanareykaapp.ui.theme.kronaOne

@Composable
fun RatingStars(rating: Int, maxStars: Int = 5) {
    Row {
        for (i in 1..maxStars) {
            val icon = if (i <= rating) R.drawable.ic_star_filled else R.drawable.ic_star_outline
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun QuestionItemCard(question: QuestionItem) {
    val commonShape = RoundedCornerShape(20.dp)
    val commonBorder = BorderStroke(1.dp, Color.White)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Блок вопроса
        Surface(
            shape = commonShape,
            color = Color(0xFF8CAAD1),
            border = commonBorder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Date of publication: ${question.date}",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    fontFamily = kronaOne
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Изменили размер шрифта на 16.sp
                Text(
                    text = "Question:\n${question.title}",
                    color = Color.White,
                    fontSize = 16.sp, // Установили конкретный размер
                    fontFamily = kronaOne,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Answered: ${question.answerCount}",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,
                        fontFamily = kronaOne
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Relevance: ",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White,
                            fontFamily = kronaOne
                        )
                        RatingStars(rating = question.relevance)
                    }
                }
            }
        }

        // Блок ответа
        Surface(
            shape = commonShape,
            color = Color(0xFF456691),
            border = commonBorder,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Quick answer:",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = kronaOne
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Заменили иконку на кастомную ic_english
                    Icon(
                        painter = painterResource(id = R.drawable.ic_english),
                        contentDescription = "User",
                        tint = Color.Unspecified, // Убедись, что иконке нужен tint. Если она уже цветная, эту строчку можно убрать.
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        text = question.userName,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontFamily = kronaOne
                    )
                    RatingStars(rating = question.userRating)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Изменили размер шрифта ответа на 16.sp
                Text(
                    text = question.answerText,
                    color = Color.White,
                    fontSize = 16.sp, // Установили 16.sp
                    textAlign = TextAlign.Center,
                    fontFamily = kronaOne,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp)
                )
            }
        }

        // Блок кнопок
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val buttonModifier = Modifier
                .weight(1f)
                .height(56.dp)
                .clip(commonShape)
                .background(Color(0xFF263E70))
                .border(commonBorder, commonShape)
                .clickable { /* TODO: Обработчик нажатия */ }

            Box(modifier = buttonModifier, contentAlignment = Alignment.Center) {
                Text(
                    text = "View answers",
                    color = Color.White,
                    fontFamily = kronaOne,
                    fontSize = 14.sp
                )
            }
            Box(modifier = buttonModifier, contentAlignment = Alignment.Center) {
                Text(
                    text = "Answer",
                    color = Color.White,
                    fontFamily = kronaOne,
                    fontSize = 14.sp
                )
            }
        }
    }
}