package com.example.andreykakanareykaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.andreykakanareykaapp.ui.theme.AndreykaKanareykaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndreykaKanareykaAppTheme {
                AppNavigation()
            }
        }
    }
}