package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Widget 7: Password Text Field
 * 
 * This file demonstrates:
 * - Material 3 OutlinedTextField component
 * - Password visibility toggle functionality
 * - Visual transformation for password masking
 * - IconButton for toggle visibility
 * - Keyboard options configuration
 * - State management for password text and visibility
 * 
 * Key Features:
 * - Password text is masked by default (shows dots)
 * - Toggle button to show/hide password
 * - Material 3 design with outlined style
 * - Proper keyboard type for password input
 */

/**
 * Password Text Field composable with visibility toggle
 * 
 * This composable demonstrates:
 * - Managing two states: password text and visibility
 * - Using VisualTransformation to mask/unmask password
 * - IconButton in trailingIcon position
 * - Conditional icon display based on state
 * - KeyboardOptions for password input type
 * 
 * Usage:
 * - User can type password (masked by default)
 * - Click eye icon to toggle visibility
 * - Password is stored in state for further processing
 */
@Composable
fun PasswordTextField() {
    // Box container to center the text field
    Box(
        contentAlignment = Alignment.Center // Center the text field
    ) {
        // State to store the password text value
        var password by remember { mutableStateOf("") }

        // State to track whether password is visible or hidden
        var passwordVisibility by remember { mutableStateOf(false) }

        // Conditional icon based on visibility state
        // Shows Visibility icon when password is visible, VisibilityOff when hidden
        val icon = if (passwordVisibility) {
            Icons.Default.Visibility // Eye icon - password is visible
        } else {
            Icons.Default.VisibilityOff // Eye with slash - password is hidden
        }

        // Material 3 OutlinedTextField for password input
        OutlinedTextField(
            value = password, // Current password text value
            onValueChange = {
                password = it // Update password state when user types
            },
            label = { Text("Password") }, // Label shown above text field when focused
            placeholder = { Text("Password") }, // Placeholder text when field is empty
            trailingIcon = {
                // IconButton positioned at the end (right side) of the text field
                IconButton(
                    onClick = {
                        // Toggle password visibility state
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        imageVector = icon, // Dynamic icon based on visibility state
                        contentDescription = "Visibility icon" // Accessibility description
                    )
                }
            },
            // Visual transformation controls how text is displayed
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None // Show text as-is when visible
            } else {
                PasswordVisualTransformation() // Mask text with dots when hidden
            },
            // Keyboard options configure the on-screen keyboard
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}

/**
 * Preview composable for testing PasswordTextField
 */
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField()
}