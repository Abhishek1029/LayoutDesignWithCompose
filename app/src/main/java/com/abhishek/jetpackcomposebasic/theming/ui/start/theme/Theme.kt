package com.abhishek.jetpackcomposebasic.theming.ui.start.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun JetNewsTheme(
    darkTheme:Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = JetNewsTypography,
        shapes = JetNewsShapes,
        content = content
    )
}

private val LightColors = lightColors(
    primary = Blue700,
    primaryVariant = Blue900,
    onPrimary = Color.White,
    secondary = Blue700,
    secondaryVariant = Blue900,
    onSecondary = Color.White,
    error = Blue800
)


private val DarkColors = darkColors(
    primary = Blue300,
    primaryVariant = Blue700,
    onPrimary = Color.Black,
    secondary = Blue300,
    onSecondary = Color.Black,
    error = Blue200
)