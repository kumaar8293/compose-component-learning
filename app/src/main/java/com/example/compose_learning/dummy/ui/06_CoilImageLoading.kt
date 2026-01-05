package com.example.compose_learning.dummy.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.compose_learning.R

@Composable
fun CoilImageLoad() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
    ) {
        AsyncImage(
            model = "https://avatars.githubusercontent.com/u/14994036?v=4",
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_google)
        )
    }
}

@Composable
fun CoilSubcomposeAsyncImage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
    ) {
        SubcomposeAsyncImage(
            model = "https://avatars.githubusercontent.com/u/14994036?v=4",
            contentDescription = null,
            modifier = Modifier.size(100.dp).animateContentSize()
        ) {
            when (painter.state) {

                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                }

                is AsyncImagePainter.State.Error -> {
                    Image(
                        painter = painterResource(R.drawable.ic_google),
                        contentDescription = "Error"
                    )
                }

                else -> {
                    SubcomposeAsyncImageContent()
                }
            }
        }
    }
}

@Preview
@Composable
fun CoilImageLoadPreview() {
    CoilImageLoad()

}