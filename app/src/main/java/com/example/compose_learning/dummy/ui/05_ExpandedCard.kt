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
    val expandedState = remember { mutableStateOf(false) }
    val rotationState = animateFloatAsState(
        targetValue = if (expandedState.value) {
            180f
        } else {
            0f
        }
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = cardShape,
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
                Text(
                    modifier = Modifier.weight(6f),
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    maxLines = titleMaxLine,
                    overflow = titleTextOverFlow
                )
                IconButton(
                    onClick = {
                        expandedState.value = !expandedState.value
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(1f)
                            .rotate(rotationState.value),
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Open dropdown",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
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

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "Hey There",
        subTitle = "Here’s the correct Material 3 way to make" +
                " ONLY the icon clickable using IconButton, " +
                "while the text stays non-clickable.",
    )
}