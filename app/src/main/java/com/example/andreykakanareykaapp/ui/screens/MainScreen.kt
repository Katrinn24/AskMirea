package com.example.andreykakanareykaapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andreykakanareykaapp.R
import com.example.andreykakanareykaapp.data.QuestionItem
import com.example.andreykakanareykaapp.ui.components.mainscreen.QuestionItemCard
import com.example.andreykakanareykaapp.ui.components.mainscreen.TopHeader

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    // Пример данных
    val questions = List(5) {
        QuestionItem(it, "01.04.26", "Why is the sky blue?", "xxx", 4, "User", 4, "The sky appears blue due to the interaction of sunlight with the Earth's atmosphere.")
    }

    Scaffold(
        topBar = { TopHeader(onProfileClick = {}) },
        containerColor = Color(0xFF2D374A)
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Image(
                painter = painterResource(id = R.drawable.questions),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(questions) { q ->
                    QuestionItemCard(question = q)
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}
