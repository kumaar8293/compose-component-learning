package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose_learning.ui.theme.Pink40
import com.example.compose_learning.ui.theme.PurpleGrey40

/**
 * Widget 8: Gradient Button
 * 
 * This file demonstrates:
 * - Custom button with gradient background
 * - Using Brush for gradient effects
 * - Material 3 Button with transparent container
 * - Custom styling with rounded corners
 * - Composable parameters for customization
 * 
 * Key Features:
 * - Horizontal gradient background (customizable colors)
 * - Rounded corners with custom shape
 * - Transparent button container to show gradient
 * - Customizable text and text color
 * - Reusable composable with default parameters
 */

/**
 * Custom gradient button composable
 * 
 * This composable creates a button with a beautiful gradient background.
 * It uses Material 3 Button as the base but makes the container transparent
 * and applies a gradient background using Brush.
 * 
 * @param text Button text to display (default: "Button")
 * @param textColor Color of the button text (default: White)
 * @param gradient Brush gradient for the background (default: horizontal gradient from PurpleGrey40 to Pink40)
 * @param onClick Callback function called when button is clicked
 * 
 * Usage example:
 * ```
 * GradientButton(
 *     text = "Click Me",
 *     textColor = Color.White,
 *     gradient = Brush.horizontalGradient(colors = listOf(Color.Blue, Color.Cyan)),
 *     onClick = { /* Handle click */ }
 * )
 * ```
 */
@Composable
fun GradientButton(
    text: String = "Button",
    textColor: Color = Color.White,
    gradient: Brush = Brush.horizontalGradient(colors = listOf(PurpleGrey40, Pink40)),
    onClick: () -> Unit
) {
    // Material 3 Button with transparent container
    // We make it transparent so the gradient background shows through
    Button(
        onClick = onClick, // Click handler
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // Transparent to show gradient
        ),
        contentPadding = PaddingValues(0.dp), // Remove default padding, we'll add our own
        elevation = ButtonDefaults.buttonElevation(0.dp) // No elevation shadow
    ) {
        // Box container that holds the gradient background and text
        Box(
            modifier = Modifier
                // Apply gradient background with rounded corners
                .background(gradient, shape = RoundedCornerShape(12.dp))
                // Add padding inside the button
                .padding(horizontal = 16.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center // Center the text content
        ) {
            // Button text
            Text(
                text = text,
                color = textColor // Customizable text color
            )
        }
    }
}

/**
 * Preview composable for testing GradientButton
 * 
 * @param modifier Optional modifier for the preview
 */
@Composable
fun GradientButtonPreview(modifier: Modifier = Modifier) {
    GradientButton(onClick = {}) // Empty click handler for preview
}