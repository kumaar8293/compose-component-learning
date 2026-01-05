package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HoistNotificationCounter() {
    val count = rememberSaveable { mutableStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        HoistNotificationCounterWithRememberSaveable(count.value, { count.value++ })
        Spacer(modifier = Modifier.height(24.dp))
        MessageBar(count.value)
    }
}

@Composable
fun HoistNotificationCounterWithRememberSaveable(count: Int, increment: () -> Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "You have sent $count notification")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            increment()
        }) {
            Text("Send Notification")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MessageBar(count: Int = 0) {
    Card(elevation = CardDefaults.elevatedCardElevation(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
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