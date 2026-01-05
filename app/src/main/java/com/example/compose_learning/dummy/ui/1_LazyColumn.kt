package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/**
 * Widget 1: LazyColumn for Efficient Lists
 * 
 * This file demonstrates:
 * - Using LazyColumn for efficient list rendering
 * - Lazy loading - only visible items are composed
 * - Better performance compared to regular Column with scroll
 * - items() DSL for adding items to LazyColumn
 * 
 * Key difference from Column:
 * - Column with verticalScroll composes ALL items immediately
 * - LazyColumn only composes visible items (lazy loading)
 * - Much better performance for large lists (100+ items)
 */

/**
 * Preview composable demonstrating LazyColumn usage
 * LazyColumn efficiently renders only visible items, improving performance
 */
@Preview(showSystemUi = true)
@Composable
fun previewLazyColumn() {
    // LazyColumn automatically handles scrolling and lazy loading
    LazyColumn {
        // items() DSL function adds items to the LazyColumn
        // Only visible items are composed, improving performance
        items(getCategoryList()) { item ->
            // Each item is a BlogCategory composable
            BlogCategory(item.image, item.title, item.subtitle)
        }
    }
}