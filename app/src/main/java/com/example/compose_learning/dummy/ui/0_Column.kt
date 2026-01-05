package com.example.compose_learning.dummy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_learning.R

/**
 * Widget 0: Column with Scrollable Blog Categories
 * 
 * This file demonstrates:
 * - Using Column with verticalScroll modifier for scrollable content
 * - Creating reusable card components (BlogCategory)
 * - Displaying lists using .map() function
 * - Material 3 Card component with elevation
 * - Row layout with weight modifiers for flexible sizing
 */

/**
 * Preview composable for testing BlogCategory in a scrollable Column
 * Note: Column with verticalScroll renders all items (not lazy), use LazyColumn for better performance
 */
@Preview(showSystemUi = true, heightDp = 500)
@Composable
fun previewBlog() {
    // Column(modifier = Modifier.verticalScroll(rememberScrollState())) makes Column scrollable
    // rememberScrollState() preserves scroll position across recompositions
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        // .map() creates a BlogCategory for each item in the list
        // Note: All items are composed immediately (not lazy)
        getCategoryList().map { item ->
            BlogCategory(item.image, item.title, item.subtitle)
        }
    }
}

/**
 * Reusable BlogCategory composable
 * Displays a card with an image, title, and subtitle
 * 
 * @param image Resource ID of the image to display
 * @param title Main title text
 * @param subTitle Secondary subtitle text
 */
@Composable
fun BlogCategory(image: Int, title: String, subTitle: String) {
    // Material 3 Card with elevation for depth effect
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp), // 8dp elevation shadow
        modifier = Modifier.padding(8.dp) // Padding around card
    ) {
        // Row layout for horizontal arrangement
        Row(
            modifier = Modifier.padding(8.dp), 
            verticalAlignment = Alignment.CenterVertically // Vertically center items
        ) {
            // Image takes 20% of available width (.2f weight)
            Image(
                painter = painterResource(id = image),
                contentDescription = null, // Decorative image, no description needed
                modifier = Modifier
                    .size(58.dp) // Fixed size
                    .weight(.2f) // 20% of row width
            )
            // Text content takes 80% of available width (.8f weight)
            ItemDescription(title, subTitle, Modifier.weight(0.8f))
        }
    }
}

/**
 * Private helper composable for displaying title and subtitle
 * 
 * @param title Main title text
 * @param subTitle Secondary subtitle text
 * @param modifier Modifier for styling and layout
 */
@Composable
private fun ItemDescription(
    title: String,
    subTitle: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        // Title uses Material 3 typography style
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        // Subtitle with lighter font weight
        Text(
            text = subTitle,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.W300 // Light font weight
        )
    }
}

/**
 * Data class representing a blog category item
 * 
 * @param image Resource ID of the category image
 * @param title Category title
 * @param subtitle Category subtitle/description
 */
data class Category(
    val image: Int,
    val title: String,
    val subtitle: String
)

/**
 * Generates a list of 100 sample Category items
 * Alternates between two different images based on index
 * 
 * @return List of Category objects
 */
fun getCategoryList(): List<Category> {
    val list = mutableListOf<Category>()
    for (i in 1..100) {
        list.add(
            Category(
                // Alternate between two images based on index
                if (i % 2 == 0) {
                    R.drawable.ic_launcher_foreground
                } else {
                    R.drawable.ic_launcher_background
                }, 
                "Alok $i", 
                "Mirzapur $i"
            )
        )
    }
    return list
}