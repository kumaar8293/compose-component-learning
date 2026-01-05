package com.example.compose_learning.dummy.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Widget 3: Remember and RememberSaveable
 * 
 * This file demonstrates:
 * - Difference between regular variable, remember, and rememberSaveable
 * - State persistence across configuration changes (screen rotation)
 * - Three different counter implementations showing state management
 * 
 * Three implementations:
 * 1. NotificationCounter() - Doesn't work (state lost on recomposition)
 * 2. NotificationCounterWithRemember() - Works but loses state on rotation
 * 3. NotificationCounterWithRememberSaveable() - Persists state across rotations
 * 
 * To test: Click buttons, rotate device to see state persistence differences
 */

/**
 * Preview screen showing all three counter implementations side by side
 */
@Preview(showSystemUi = true)
@Composable
fun NotificationScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounterTest()
    }
}

/**
 * Container composable displaying all three counter variants
 * Allows comparison of different state management approaches
 */
@Composable
fun NotificationCounterTest() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Counter without state management - won't work
        NotificationCounter()
        Spacer(modifier = Modifier.height(24.dp))
        // Counter with remember - works but loses state on rotation
        NotificationCounterWithRemember()
        Spacer(modifier = Modifier.height(24.dp))
        // Counter with rememberSaveable - persists state across rotations
        NotificationCounterWithRememberSaveable()
    }
}

/**
 * Counter implementation WITHOUT state management
 * 
 * PROBLEM: This doesn't work because:
 * - 'count' is a regular variable, reset to 0 on every recomposition
 * - Clicking button triggers recomposition, but count is reset before UI updates
 * - State is lost immediately after recomposition
 * 
 * This demonstrates why state management is essential in Compose
 */
@Composable
fun NotificationCounter() {
    var count = 0 // Regular variable - reset on every recomposition
    Column() {
        Text(text = "You have sent $count notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count++ // This change is lost on recomposition
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification")
        }
    }
}

/**
 * Counter implementation WITH remember
 * 
 * WORKS BUT HAS LIMITATIONS:
 * - remember preserves state across recompositions
 * - State persists as long as the composable stays in composition
 * - BUT: State is lost when activity is recreated (e.g., screen rotation)
 * 
 * Use remember when:
 * - State doesn't need to survive configuration changes
 * - State is only needed during the composable's lifetime
 */
@Composable
fun NotificationCounterWithRemember() {
    // remember preserves state across recompositions
    // State survives recomposition but NOT activity recreation
    val count = remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent ${count.value} notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count.value++ // State change triggers recomposition
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification with state")
        }
    }
}

/**
 * Counter implementation WITH rememberSaveable
 * 
 * BEST PRACTICE:
 * - rememberSaveable preserves state across configuration changes
 * - State survives screen rotation, activity recreation, etc.
 * - Uses Bundle to save/restore state automatically
 * 
 * Use rememberSaveable when:
 * - State needs to survive configuration changes
 * - State should persist across activity lifecycle events
 * - Default choice for most state management scenarios
 */
@Composable
fun NotificationCounterWithRememberSaveable() {
    // rememberSaveable preserves state across configuration changes
    // State survives activity recreation (rotation, etc.)
    val count = rememberSaveable { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent ${count.value} notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count.value++ // State change triggers recomposition
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification with state")
        }
    }
}