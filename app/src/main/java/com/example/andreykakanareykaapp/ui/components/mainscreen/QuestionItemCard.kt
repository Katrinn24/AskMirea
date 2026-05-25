package com.example.andreykakanareykaapp.ui.components.mainscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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

    Column(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Блок вопроса
        Surface(shape = commonShape, color = Color(0xFF8CAAD1), border = commonBorder, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Date of publication: ${question.date}", style = MaterialTheme.typography.labelSmall, color = Color.White, fontFamily = kronaOne)
                Text(text = "Question:\n${question.title}", style = MaterialTheme.typography.titleMedium, color = Color.White,fontFamily = kronaOne)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Answered: ${question.answerCount}", color = Color.White,fontFamily = kronaOne)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Relevance: ", color = Color.White,fontFamily = kronaOne)
                        RatingStars(rating = question.relevance)
                    }
                }
            }
        }

        // Блок ответа
        Surface(shape = commonShape, color = Color(0xFF456691), border = commonBorder, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Best answer:", color = Color.White, style = MaterialTheme.typography.labelSmall,fontFamily = kronaOne)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = question.userName, color = Color.White, style = MaterialTheme.typography.titleSmall,fontFamily = kronaOne)
                    RatingStars(rating = question.userRating)
                }
                Text(text = question.answerText, color = Color.White, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp),fontFamily = kronaOne)
            }
        }

        // Блок кнопок
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val buttonModifier = Modifier.weight(1f).height(50.dp).background(Color(0xFF123262), commonShape).border(commonBorder, commonShape)
            Box(modifier = buttonModifier, contentAlignment = Alignment.Center) { Text("View answers", color = Color.White,fontFamily = kronaOne) }
            Box(modifier = buttonModifier, contentAlignment = Alignment.Center) { Text("Answer", color = Color.White,fontFamily = kronaOne) }
        }
    }
}