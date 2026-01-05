package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun previewLazyColumn() {
    LazyColumn {
        items(getCategoryList()) { item ->
            BlogCategory(item.image, item.title, item.subtitle)
        }
    }
}