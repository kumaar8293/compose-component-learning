package com.example.compose_learning.dummy.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_learning.R
import com.example.compose_learning.ui.theme.Shapes


@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account...",
    loginIcon: Painter = painterResource(R.drawable.ic_google),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    surfaceColor: Color = MaterialTheme.colorScheme.surface,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClicked: () -> Unit
) {
    val clicked = remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.background(backgroundColor),
        onClick = {
            clicked.value = !clicked.value
        },
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
        color = surfaceColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Icon(
                painter = loginIcon,
                contentDescription = "Google icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (clicked.value) {
                    loadingText
                } else {
                    text
                }
            )
            if (clicked.value) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onClicked()
            }
        }

    }

}

@Preview
@Composable
fun GoogleButtonPreview() {
    GoogleButton{

    }
}