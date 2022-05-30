package com.example.alarm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alarm.navigation.NavHostNav
import com.example.alarm.ui.theme.AlarmTheme
import com.example.alarm.ui.theme.Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmTheme {
                // A surface container using the 'background' color from the theme
                val systemUiController = rememberSystemUiController()
                val primaryBackground = Theme.colors.primaryBackground
                val paddingValues = PaddingValues(start = 16.dp, end = 16.dp, top = 24.dp)
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackground,
                        darkIcons = true
                    )
                }
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Theme.colors.primaryBackground)) {
                    NavHostNav(background = primaryBackground)
                }
            }
        }
    }
}