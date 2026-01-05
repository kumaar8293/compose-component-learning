package com.example.compose_learning.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Dark color scheme for the application
 * Uses lighter color shades optimized for dark backgrounds
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

/**
 * Light color scheme for the application
 * Uses darker color shades optimized for light backgrounds
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors can be overridden here:
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

/**
 * Main theme composable for the application
 * 
 * This composable sets up the Material 3 theme with:
 * - Color scheme (light/dark/dynamic)
 * - Typography system
 * - Shape system
 * 
 * Features:
 * - Supports dynamic colors on Android 12+ (Material You)
 * - Automatically follows system dark theme preference
 * - Falls back to custom color schemes on older Android versions
 * 
 * @param darkTheme Whether to use dark theme (default: follows system preference)
 * @param dynamicColor Whether to use dynamic colors on Android 12+ (default: true)
 * @param content The composable content to apply the theme to
 */
@Composable
fun ComposelearningTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Follow system dark theme preference
    // Dynamic color is available on Android 12+ (Material You)
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Determine which color scheme to use
    val colorScheme = when {
        // Use dynamic colors on Android 12+ if enabled
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            // Choose dark or light dynamic color scheme based on theme preference
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        // Use custom dark color scheme
        darkTheme -> DarkColorScheme
        // Use custom light color scheme
        else -> LightColorScheme
    }

    // Apply Material 3 theme with selected color scheme and typography
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Typography defined in Type.kt
        content = content
    )
}