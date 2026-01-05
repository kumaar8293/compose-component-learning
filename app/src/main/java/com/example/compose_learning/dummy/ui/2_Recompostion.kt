package com.example.compose_learning.dummy.ui

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecompositionDemo() {
    val state = remember { mutableStateOf(0.0) }
    Log.d("LENSA", "RecompositionDemo: initial composition")

    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("LENSA", "RecompositionDemo: initial & recomposition")
        Text(text = state.value.toString())
    }
}