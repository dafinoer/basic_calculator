package com.dafinrs.calculatorcompose.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object AppColorTheme {

    val dark = darkColorScheme(
        primary = Color(0xff67e100),
        secondary = Color(0xff283420),
        tertiary = Color(0xffa0cfcf),
        surface = Color(0xff1a1c18),
        onSurface = Color(0xffe3e3dc),
        surfaceVariant = Color(0xff43483e),
        onSurfaceVariant = Color(0xffc4c8bb),
    )

    val light = lightColorScheme(
        primary = Color(0xff2e6c00),
        secondary = Color(0xff56624b),
        tertiary = Color(0xff386666),
        surface = Color(0xfffdfdf5),
        onSurface = Color(0xff1a1c18),
        surfaceVariant = Color(0xffe0e4d6),
        onSurfaceVariant = Color(0xff43483e),
    )
}