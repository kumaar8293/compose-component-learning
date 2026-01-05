package com.example.compose_learning.dummy.ui

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

/**
 * Widget 2: Recomposition Demo
 * 
 * This file demonstrates:
 * - Understanding Compose recomposition
 * - How state changes trigger recomposition
 * - Using remember to preserve state across recompositions
 * - Logging recomposition behavior
 * 
 * Key Concepts:
 * - Recomposition: Re-execution of composables when state changes
 * - remember: Preserves value across recompositions
 * - mutableStateOf: Creates observable state that triggers recomposition when changed
 * 
 * To test: Run app, click button, check Logcat for "LENSA" tag to see recomposition logs
 */

/**
 * Demonstrates recomposition behavior
 * 
 * When button is clicked:
 * 1. state.value changes
 * 2. Recomposition is triggered
 * 3. RecompositionDemo() is called again
 * 4. Button and Text are recomposed with new state value
 * 
 * Note: Logs will show "initial composition" once, but "initial & recomposition" 
 * will appear on every recomposition (including the initial one)
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecompositionDemo() {
    // remember preserves the mutableStateOf across recompositions
    // Without remember, state would be reset to 0.0 on every recomposition
    val state = remember { mutableStateOf(0.0) }
    
    // This log appears only once during initial composition
    Log.d("LENSA", "RecompositionDemo: initial composition")

    Button(onClick = {
        // Changing state.value triggers recomposition
        state.value = Math.random()
    }) {
        // This log appears on initial composition AND every recomposition
        Log.d("LENSA", "RecompositionDemo: initial & recomposition")
        // Text displays current state value
        Text(text = state.value.toString())
    }
}