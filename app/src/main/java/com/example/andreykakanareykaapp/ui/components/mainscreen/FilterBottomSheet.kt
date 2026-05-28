package com.example.andreykakanareykaapp.ui.components.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andreykakanareykaapp.R

val KronaOneFont = FontFamily(Font(R.font.krona_one))

@Composable
fun FilterSheetContent() {
    // 1. Поменяли градиенты на линейные (linearGradient)
    val sheetGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF123262), Color(0xFF3B71B0))
    )
    val clearBtnGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF263E70), Color(0xFF456691))
    )
    // Добавим отдельный градиент для кнопки Apply, чтобы она слегка выделялась (по желанию можешь использовать clearBtnGradient)
    val applyBtnGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF456691), Color(0xFF263E70))
    )

    var selectedSemester by remember { mutableStateOf("Choose") }
    var selectedDirection by remember { mutableStateOf("Choose") }
    var selectedSubject by remember { mutableStateOf("Choose") }
    var selectedTopic by remember { mutableStateOf("Choose") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            // 2. Добавили белую рамку 1.dp с тем же скруглением углов
            .border(1.dp, Color.White, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(sheetGradient)
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(60.dp)
                .height(4.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Filters:",
            color = Color.White,
            fontFamily = KronaOneFont,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilterDropdownItem(
                modifier = Modifier.weight(1f),
                title = "Semester",
                selectedValue = selectedSemester,
                options = listOf("1", "2", "3", "4", "5", "6", "7", "8"),
                onValueChange = { selectedSemester = it }
            )
            FilterDropdownItem(
                modifier = Modifier.weight(1f),
                title = "Direction",
                selectedValue = selectedDirection,
                options = listOf("IIT", "IAI", "ICST", "IREI", "IATI", "ILCT", "IMT"),
                onValueChange = { selectedDirection = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilterDropdownItem(
                modifier = Modifier.weight(1f),
                title = "Subject",
                selectedValue = selectedSubject,
                options = listOf("Physics", "Mathematical analysis", "OOP", "Linear algebra", "Other"),
                onValueChange = { selectedSubject = it }
            )
            FilterDropdownItem(
                modifier = Modifier.weight(1f),
                title = "Topic",
                selectedValue = selectedTopic,
                options = listOf("Kinematics", "Dynamics", "Optics", "Other"),
                onValueChange = { selectedTopic = it }
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Кнопка Clear filters
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
                    .background(clearBtnGradient)
                    .clickable {
                        selectedSemester = "Choose"
                        selectedDirection = "Choose"
                        selectedSubject = "Choose"
                        selectedTopic = "Choose"
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Clear\nfilters",
                    color = Color.White,
                    fontFamily = KronaOneFont,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }

            // Кнопка Apply filters
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp))
                    .background(applyBtnGradient)
                    .clickable {
                        // TODO: Здесь будет логика применения фильтров и закрытия шторки
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Apply\nfilters",
                    color = Color.White,
                    fontFamily = KronaOneFont,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDropdownItem(
    modifier: Modifier = Modifier,
    title: String,
    selectedValue: String,
    options: List<String>,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    // Заодно поменяли на линейный и градиент самих ячеек, чтобы стилистика была единой
    val fieldGradient = Brush.linearGradient(
        colors = listOf(Color(0xFF5A8AD2), Color(0xFFABC7DE))
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, Color.White, RoundedCornerShape(16.dp))
                .background(fieldGradient)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontFamily = KronaOneFont,
                    fontSize = 14.sp
                )
                Text(
                    text = selectedValue,
                    color = Color.White,
                    fontFamily = KronaOneFont,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption, fontFamily = KronaOneFont) },
                    onClick = {
                        onValueChange(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}