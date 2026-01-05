package com.example.compose_learning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_learning.dummy.ui.BlogCategory
import com.example.compose_learning.dummy.ui.ExpandableCard
import com.example.compose_learning.dummy.ui.GoogleButton
import com.example.compose_learning.dummy.ui.HoistNotificationCounter
import com.example.compose_learning.dummy.ui.NotificationCounter
import com.example.compose_learning.dummy.ui.NotificationCounterTest
import com.example.compose_learning.dummy.ui.RecompositionDemo
import com.example.compose_learning.dummy.ui.getCategoryList
import com.example.compose_learning.ui.theme.ComposelearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //====== 0==========
//            Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//                getCategoryList().map { item ->
//                    BlogCategory(item.image, item.title, item.subtitle)
//                }
//            }

            //====== 1 ==========
//            LazyColumn {
//                items(getCategoryList()) { item ->
//                    BlogCategory(item.image, item.title, item.subtitle)
//                }
//            }

            //====== 2 ==========
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .statusBarsPadding(), // 👈 pushes content below status bar
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                RecompositionDemo()
//            }

            //====== 3 ==========

//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize(1f)
//            ) {
//                NotificationCounterTest()
//            }

            //====== 4 ==========
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize(1f)
//            ) {
//                HoistNotificationCounter()
//            }

            //====== 5 Expanded Card ==========

//            Column(
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.LightGray)
//                    .padding(32.dp)
//
//            ) {
//                ExpandableCard(
//                    title = "Hey There",
//                    subTitle = "Here’s the correct Material 3 way to make" +
//                            " ONLY the icon clickable using IconButton, " +
//                            "while the text stays non-clickable.",
//                )
//            }

            //====== 6 Google Signup button ==========
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                GoogleButton() {
                    Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ModifireDummy() {
    Column {
        Text(
            text = "Hello",
            color = Color.Blue,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clickable {}
                .background(Color.Blue)
                .size(200.dp)
                .padding(36.dp)
                .clip(CircleShape)
                .border(2.dp, color = Color.Red, shape = CircleShape)
                .background(color = Color.Yellow)

        )
        CircularImage()
    }
}

@Composable
fun CircularImage() {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(
            R.drawable.ic_launcher_foreground
        ),
        contentDescription = "",
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape),
        colorFilter = ColorFilter.tint(Color.Red)
    )
}


@Composable
fun ListViewItem(imageId: Int, title: String, subtitle: String) {
    Row(Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "User icon",
            modifier = Modifier.size(70.dp),
        )

        Column(Modifier.padding(8.dp)) {
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 14.sp, fontWeight = FontWeight.W300)
        }
    }
}


@Composable
fun TextInputPreview() {
    Column() {
        ListViewItem(
            R.drawable.ic_launcher_foreground,
            "Alok Upadhayay 0",
            "Mirzapur wale"
        )
        ListViewItem(
            R.drawable.ic_launcher_foreground,
            "Alok Upadhayay 1",
            "Mirzapur wale"
        )
        ListViewItem(
            R.drawable.ic_launcher_foreground,
            "Alok Upadhayay 2",
            "Mirzapur wale"
        )
        ListViewItem(
            R.drawable.ic_launcher_foreground,
            "Alok Upadhayay 3",
            "Mirzapur wale"
        )
        ListViewItem(
            R.drawable.ic_launcher_foreground,
            "Alok Upadhayay 4",
            "Mirzapur wale"
        )

    }
}
