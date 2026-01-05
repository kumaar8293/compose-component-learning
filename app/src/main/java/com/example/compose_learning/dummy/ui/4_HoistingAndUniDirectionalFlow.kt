package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Widget 4: Hoisting and Unidirectional Data Flow
 * 
 * This file demonstrates:
 * - State hoisting pattern (moving state to common ancestor)
 * - Unidirectional data flow (state flows down, events flow up)
 * - Sharing state between multiple composables
 * - Best practices for state management in Compose
 * 
 * Key Concepts:
 * - State Hoisting: State is stored in parent composable
 * - Unidirectional Flow: State passed down as parameters, events passed up as callbacks
 * - Reusable Composables: Child composables receive state and callbacks, not managing state themselves
 * 
 * Benefits:
 * - Single source of truth
 * - Easier to test and reason about
 * - Better composability and reusability
 */

/**
 * Parent composable that hoists the state
 * 
 * This demonstrates state hoisting:
 * - State (count) is stored in the parent (HoistNotificationCounter)
 * - State is passed down to child composables as parameters
 * - Events (increment) are passed up as lambda callbacks
 * - Multiple children can share the same state
 */
@Composable
fun HoistNotificationCounter() {
    // State is hoisted to parent composable
    val count = rememberSaveable { mutableStateOf(0) }
    
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        
        // Pass state down as parameter, event handler as callback
        HoistNotificationCounterWithRememberSaveable(
            count = count.value, // State flows down
            increment = { count.value++ } // Event flows up
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Another composable sharing the same state
        MessageBar(count.value) // State flows down
    }
}

/**
 * Child composable that receives state and callback
 * 
 * This demonstrates unidirectional data flow:
 * - Receives state (count) as parameter (read-only)
 * - Receives event handler (increment) as lambda callback
 * - Does NOT manage its own state
 * - Reusable and testable
 * 
 * @param count Current count value (state flows down)
 * @param increment Callback function to increment count (event flows up)
 */
@Composable
fun HoistNotificationCounterWithRememberSaveable(
    count: Int, 
    increment: () -> Unit // Callback that doesn't return a value
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent $count notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            // Call parent's callback instead of modifying state directly
            increment() // Event flows up to parent
        }) {
            Text("Send Notification")
        }
    }
}

/**
 * Message bar composable that displays count
 * 
 * Demonstrates:
 * - Receiving state as parameter
 * - Reacting to state changes
 * - Reusable composable that doesn't manage state
 * 
 * @param count Current count value to display
 */
@Preview(showSystemUi = true)
@Composable
fun MessageBar(count: Int = 0) {
    Card(elevation = CardDefaults.elevatedCardElevation(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "Favorite icon",
                modifier = Modifier.padding(4.dp),
                tint = Color.Red
            )
            Text(
                "Message sent so far $count",
                modifier = Modifier.padding(8.dp),
                fontStyle = FontStyle.Italic
            )
        }
    }
}