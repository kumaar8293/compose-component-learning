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


@Preview(showSystemUi = true, heightDp = 500)
@Composable
fun previewBlog() {
    //  Column(modifier = Modifier.verticalScroll(rememberScrollState())) it will make Column scrollable
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map { item ->
            BlogCategory(item.image, item.title, item.subtitle)
        }
    }
}

@Composable
fun BlogCategory(image: Int, title: String, subTitle: String) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(58.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(0.8f))
        }

    }
}

@Composable
private fun ItemDescription(
    title: String,
    subTitle: String,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Text(
            text = subTitle,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.W300
        )
    }
}

data class Category(
    val image: Int,
    val title: String,
    val subtitle: String
)

fun getCategoryList(): List<Category> {
    val list = mutableListOf<Category>()
    for (i in 1..100) {
        list.add(
            Category(
                if (i % 2 == 0) {
                    R.drawable.ic_launcher_foreground
                } else {
                    R.drawable.ic_launcher_background
                }, "Alok $i", "Mirzapur $i"
            )
        )
    }
    return list
}