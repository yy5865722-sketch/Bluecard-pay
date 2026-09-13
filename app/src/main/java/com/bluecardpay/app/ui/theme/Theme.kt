package com.bluecardpay.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val BluePrimary = Color(0xFF0066CC)
private val BlueDark = Color(0xFF003E99)
private val BlueLite = Color(0xFF4D94FF)
private val White = Color(0xFFFFFFFF)
private val DarkBackground = Color(0xFF121212)
private val LightBackground = Color(0xFFFAFAFA)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = White,
    primaryContainer = BlueLite,
    onPrimaryContainer = BlueDark,
    secondary = BlueDark,
    onSecondary = White,
    tertiary = BlueLite,
    onTertiary = BlueDark,
    background = LightBackground,
    onBackground = Color(0xFF1A1A1A),
    surface = White,
    onSurface = Color(0xFF1A1A1A),
    error = Color(0xFFB3261E),
    onError = White
)

private val DarkColorScheme = darkColorScheme(
    primary = BlueLite,
    onPrimary = BlueDark,
    primaryContainer = BluePrimary,
    onPrimaryContainer = BlueLite,
    secondary = BlueLite,
    onSecondary = BlueDark,
    tertiary = BlueDark,
    onTertiary = BlueLite,
    background = DarkBackground,
    onBackground = White,
    surface = Color(0xFF1E1E1E),
    onSurface = White,
    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410)
)

@Composable
fun BlueCardPayTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
