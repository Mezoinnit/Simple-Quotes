package com.example.quotely

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.quotely.qutotely.presentation.QuoteScreen
import com.example.quotely.ui.theme.QuotelyTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            val systemUi = rememberSystemUiController()
            systemUi.isSystemBarsVisible = false
            QuotelyTheme {
                QuoteScreen()
            }
        }
    }
}