package com.example.compose_learning.dummy.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.compose_learning.ui.theme.Shapes

/**
 * Widget 5: Expandable Card
 * 
 * This file demonstrates:
 * - Animated expandable/collapsible card component
 * - Material 3 IconButton usage (only icon is clickable, not text)
 * - Content size animations with animateContentSize()
 * - Icon rotation animations with animateFloatAsState()
 * - Conditional composition (showing/hiding content)
 * - Highly customizable card component with multiple parameters
 * 
 * Key Features:
 * - Smooth expand/collapse animation
 * - Rotating dropdown icon
 * - Clickable card OR icon button
 * - Customizable typography, shapes, and padding
 */

/**
 * Expandable card composable with smooth animations
 * 
 * Demonstrates Material 3 best practices:
 * - IconButton makes ONLY the icon clickable (not the entire row)
 * - Card can also be clicked to toggle expansion
 * - Smooth animations for size and rotation
 * 
 * @param title Main title text displayed when collapsed
 * @param titleFontSize Font size for title (default: MaterialTheme titleLarge)
 * @param titleFontWeight Font weight for title (default: Bold)
 * @param titleMaxLine Maximum lines for title (default: 1)
 * @param titleTextOverFlow Text overflow behavior for title (default: Ellipsis)
 * @param subTitle Content text displayed when expanded
 * @param subTitleFontSize Font size for subtitle (default: MaterialTheme titleSmall)
 * @param subTitleFontWeight Font weight for subtitle (default: Normal)
 * @param subtitleMaxLine Maximum lines for subtitle (default: 4)
 * @param subTitleTextOverflow Text overflow behavior for subtitle (default: Ellipsis)
 * @param cardShape Shape of the card (default: Shapes.large)
 * @param padding Internal padding of the card (default: 12.dp)
 */
@Composable
fun ExpandableCard(
    title: String,
    titleFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    titleMaxLine: Int = 1,
    titleTextOverFlow: TextOverflow = TextOverflow.Ellipsis,
    subTitle: String,
    subTitleFontSize: TextUnit = MaterialTheme.typography.titleSmall.fontSize,
    subTitleFontWeight: FontWeight = FontWeight.Normal,
    subtitleMaxLine: Int = 4,
    subTitleTextOverflow: TextOverflow = TextOverflow.Ellipsis,
    cardShape: Shape = Shapes.large,
    padding: Dp = 12.dp
) {
    // State to track expanded/collapsed state
    val expandedState = remember { mutableStateOf(false) }
    
    // Animated rotation for dropdown icon (0° when collapsed, 180° when expanded)
    val rotationState = animateFloatAsState(
        targetValue = if (expandedState.value) {
            180f // Rotated when expanded
        } else {
            0f // Normal position when collapsed
        },
        label = "icon_rotation" // Label for animation tracking
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            // Animate content size changes smoothly
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300, // Animation duration
                    easing = LinearOutSlowInEasing // Easing function
                )
            ),
        shape = cardShape,
        // Card itself is clickable (alternative to IconButton)
        onClick = {
            expandedState.value = !expandedState.value
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Title takes 85.7% of width (6/7)
                Text(
                    modifier = Modifier.weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = titleMaxLine,
                    overflow = titleTextOverFlow
                )
                
                // IconButton makes ONLY the icon clickable (Material 3 best practice)
                IconButton(
                    onClick = {
                        expandedState.value = !expandedState.value
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(1f) // Icon takes 14.3% of width (1/7)
                            .rotate(rotationState.value), // Animated rotation
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Open dropdown",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            // Conditionally show subtitle when expanded
            // This is conditional composition - content is added/removed from composition
            if (expandedState.value) {
                Text(
                    text = subTitle,
                    fontSize = subTitleFontSize,
                    fontWeight = subTitleFontWeight,
                    maxLines = subtitleMaxLine,
                    overflow = subTitleTextOverflow
                )
            }
        }
    }
}

/**
 * Preview composable for testing ExpandableCard
 */
@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "Hey There",
        subTitle = "Here's the correct Material 3 way to make" +
                " ONLY the icon clickable using IconButton, " +
                "while the text stays non-clickable.",
    )
}