package com.example.andreykakanareykaapp.data // Пакет подтянется автоматически

data class QuestionItem(
    val id: Int,
    val date: String,
    val title: String,
    val answerCount: String,
    val relevance: Int,
    val userName: String,
    val userRating: Int,
    val answerText: String
)