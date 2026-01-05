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

@Composable
fun NotificationCounterTest() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        NotificationCounter()
        Spacer(modifier = Modifier.height(24.dp))
        NotificationCounterWithRemember()
        NotificationCounterWithRememberSaveable()
    }
}

@Composable
fun NotificationCounter() {
    var count = 0
    Column() {
        Text(text = "You have sent $count notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count++
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification")
        }
    }
}

/**
 * NotificationCounterWithRemember will work fine but if you rotate the screen
 * then it will recreate the activity and lost the data.
 * It will recall the NotificationCounterWithRemember composition.
 *
 * remember keep the data for that composable function only.. If you want to save the data even after recreation then use
 */
@Composable
fun NotificationCounterWithRemember() {
    val count = remember { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent ${count.value} notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count.value++
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification with state")
        }
    }
}

@Composable
fun NotificationCounterWithRememberSaveable() {
    val count = rememberSaveable { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent ${count.value} notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            count.value++
            Log.d("LENSA", "NotificationCounter: button clicked $count")
        }) {
            Text("Send Notification with state")
        }
    }
}