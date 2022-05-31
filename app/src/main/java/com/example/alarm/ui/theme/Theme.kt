package com.example.alarm.ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val darkPalette = Colors(
    primaryBackground = Color(0xFF1D1D23),
    secondaryBackground = Color(0xFF34344A),
    headerTextColor = Color(0xFFFAFAFA),
    buttonBackground = Color(0xFFF0F757),
    activeTextColor = Color(0xFFFFFFFF),
    inactiveTextColor = Color(0xFFCFCFCF),
    menuBackground = Color(0xFF000000),
    inactiveRadioButton = Color(0xFF535378)
)

object Theme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default colors provided")
}

@Composable
fun AlarmTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides darkPalette,
        content = content
    )
}