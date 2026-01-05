package com.example.compose_learning.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography theme definitions for Material 3
 * 
 * This file defines the text styles used throughout the app.
 * Material 3 provides a comprehensive typography system with predefined styles.
 * 
 * Available text styles (can be customized):
 * - displayLarge, displayMedium, displaySmall
 * - headlineLarge, headlineMedium, headlineSmall
 * - titleLarge, titleMedium, titleSmall
 * - bodyLarge, bodyMedium, bodySmall
 * - labelLarge, labelMedium, labelSmall
 * 
 * Currently only bodyLarge is customized. Other styles use Material 3 defaults.
 */
val Typography = Typography(
    // Body text style - used for main content text
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles can be overridden here:
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)