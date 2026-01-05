package com.example.compose_learning.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Shape theme definitions for Material 3 components
 * 
 * This file defines the shape system used throughout the app.
 * Shapes are used for components like Cards, Buttons, TextFields, etc.
 * 
 * Material 3 uses three size categories:
 * - small: Used for small components (e.g., chips, badges)
 * - medium: Used for medium components (e.g., buttons, cards)
 * - large: Used for large components (e.g., sheets, dialogs)
 */
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),   // Small components: 4dp corner radius
    medium = RoundedCornerShape(4.dp),  // Medium components: 4dp corner radius
    large = RoundedCornerShape(8.dp)    // Large components: 8dp corner radius
)