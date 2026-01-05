package com.example.compose_learning.dummy.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_learning.R
import com.example.compose_learning.ui.theme.Shapes

/**
 * Widget 6: Google Sign Up Button
 * 
 * This file demonstrates:
 * - Custom button component with loading state
 * - Animated content size transitions
 * - Progress indicator integration
 * - Click handling with callbacks
 * - Material 3 Surface component with border
 * - Conditional composition based on state
 * 
 * Key Features:
 * - Smooth text transition when loading
 * - Animated progress indicator appearance
 * - Customizable colors, shapes, and text
 * - Callback function for handling click events
 */

/**
 * Custom Google sign-up button with loading state
 * 
 * This composable demonstrates:
 * - Managing loading state internally
 * - Animating content size changes
 * - Showing/hiding progress indicator conditionally
 * - Using Material 3 Surface for button appearance
 * - Callback pattern for handling user actions
 * 
 * @param text Button text when not loading (default: "Sign Up with Google")
 * @param loadingText Button text when loading (default: "Creating Account...")
 * @param loginIcon Icon painter to display (default: Google icon)
 * @param shape Shape of the button (default: Shapes.medium)
 * @param borderColor Color of the border (default: LightGray)
 * @param backgroundColor Background color behind button (default: MaterialTheme background)
 * @param surfaceColor Surface/button color (default: MaterialTheme surface)
 * @param progressIndicatorColor Color of loading indicator (default: MaterialTheme primary)
 * @param onClicked Callback function called when button is clicked
 */
@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account...",
    loginIcon: Painter = painterResource(R.drawable.ic_google),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    surfaceColor: Color = MaterialTheme.colorScheme.surface,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClicked: () -> Unit
) {
    // Internal state to track loading/clicked state
    val clicked = remember { mutableStateOf(false) }
    
    // Material 3 Surface component - provides elevation and click handling
    Surface(
        modifier = Modifier.background(backgroundColor),
        onClick = {
            // Toggle loading state when clicked
            clicked.value = !clicked.value
        },
        shape = shape,
        border = BorderStroke(1.dp, borderColor), // Border around button
        color = surfaceColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                // Animate size changes when content changes (text + progress indicator)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300, // Animation duration
                        easing = LinearOutSlowInEasing // Smooth easing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Google icon
            Icon(
                painter = loginIcon,
                contentDescription = "Google icon",
                tint = Color.Unspecified // Use original icon colors
            )
            Spacer(modifier = Modifier.width(8.dp))
            
            // Text changes based on loading state
            Text(
                text = if (clicked.value) {
                    loadingText // Show loading text
                } else {
                    text // Show normal text
                }
            )
            
            // Conditionally show progress indicator when loading
            if (clicked.value) {
                Spacer(modifier = Modifier.width(16.dp))
                // Small circular progress indicator
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                // Call callback function when loading starts
                onClicked()
            }
        }
    }
}

/**
 * Preview composable for testing GoogleButton
 */
@Preview
@Composable
fun GoogleButtonPreview() {
    GoogleButton {
        // Empty callback for preview
    }
}