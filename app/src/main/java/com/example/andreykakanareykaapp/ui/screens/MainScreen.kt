package com.example.andreykakanareykaapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.andreykakanareykaapp.ui.components.mainscreen.FilterSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val questions = List(10) {
        QuestionItem(
            it,
            "01.04.26",
            "Why is the sky blue?",
            "xxx",
            4,
            "User",
            4,
            "The sky appears blue due to the interaction of sunlight with the Earth's atmosphere."
        )
    }

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded
        )
    )

    Scaffold(
        topBar = { TopHeader(onProfileClick = {}) },
        // УБРАЛИ floatingActionButton отсюда
        containerColor = Color(0xFF2D374A)
    ) { scaffoldPadding ->

        BottomSheetScaffold(
            modifier = Modifier.padding(scaffoldPadding),
            scaffoldState = bottomSheetScaffoldState,
            sheetPeekHeight = 100.dp,
            sheetContainerColor = Color.Transparent,
            containerColor = Color.Transparent,
            sheetShadowElevation = 0.dp,
            sheetTonalElevation = 0.dp,
            sheetDragHandle = null,
            sheetContent = {
                FilterSheetContent()
            }
        ) { innerPadding ->

            // Внутренний Box с контентом
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Этот отступ автоматически поднимает контент над шторкой
            ) {
                // Фон
                Image(
                    painter = painterResource(id = R.drawable.questions),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Список
                LazyColumn(
                    // Добавил отступ снизу (bottom = 88.dp), чтобы кнопка не перекрывала последнюю карточку в списке
                    contentPadding = PaddingValues(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 88.dp)
                ) {
                    items(questions) { q ->
                        QuestionItemCard(question = q)
                    }
                }

                // ПЕРЕНЕСЛИ КНОПКУ СЮДА
                FloatingActionButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // Прижимаем в правый нижний угол
                        .padding(end = 23.dp, bottom = 6.dp)
                        .border(width = 1.dp, color = Color.White, shape = CircleShape),
                    shape = CircleShape,
                    containerColor = Color(0xFF183F7C)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_pen),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}