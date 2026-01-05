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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.example.compose_learning.dummy.ui.CoilImageLoad
import com.example.compose_learning.dummy.ui.CoilSubcomposeAsyncImage
import com.example.compose_learning.dummy.ui.ExpandableCard
import com.example.compose_learning.dummy.ui.GoogleButton
import com.example.compose_learning.dummy.ui.GradientButton
import com.example.compose_learning.dummy.ui.HoistNotificationCounter
import com.example.compose_learning.dummy.ui.NotificationCounter
import com.example.compose_learning.dummy.ui.NotificationCounterTest
import com.example.compose_learning.dummy.ui.PasswordTextField
import com.example.compose_learning.dummy.ui.RecompositionDemo
import com.example.compose_learning.dummy.ui.getCategoryList
import com.example.compose_learning.ui.theme.ComposelearningTheme

/**
 * MainActivity - Entry point of the application
 * 
 * This activity demonstrates various Jetpack Compose widgets and concepts.
 * To test different widgets, uncomment the corresponding section below.
 * Only one section should be active at a time.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display (content can extend behind system bars)
        enableEdgeToEdge()
        setContent {
            //====== 0: Column with Scrollable Blog Categories ==========
            // Demonstrates: Column with verticalScroll, reusable BlogCategory composable
            // How to test: Uncomment lines below and comment out other active sections
//            Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//                getCategoryList().map { item ->
//                    BlogCategory(item.image, item.title, item.subtitle)
//                }
//            }

            //====== 1: LazyColumn for Efficient Lists ==========
            // Demonstrates: LazyColumn for better performance with large lists
            // How to test: Uncomment lines below and comment out other active sections
//            LazyColumn {
//                items(getCategoryList()) { item ->
//                    BlogCategory(item.image, item.title, item.subtitle)
//                }
//            }

            //====== 2: Recomposition Demo ==========
            // Demonstrates: Understanding recomposition and state management with remember
            // How to test: Uncomment lines below, run app, click button, check Logcat for "LENSA" tag
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .statusBarsPadding(), // 👈 pushes content below status bar
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                RecompositionDemo()
//            }

            //====== 3: Remember and RememberSaveable ==========
            // Demonstrates: Difference between remember and rememberSaveable
            // How to test: Uncomment lines below, click buttons, rotate device to see state persistence
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize(1f)
//            ) {
//                NotificationCounterTest()
//            }

            //====== 4: Hoisting and Unidirectional Data Flow ==========
            // Demonstrates: State hoisting pattern and sharing state between composables
            // How to test: Uncomment lines below and observe how state is shared between components
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize(1f)
//            ) {
//                HoistNotificationCounter()
//            }

            //====== 5: Expandable Card ==========
            // Demonstrates: Animated expandable card with Material 3 IconButton
            // How to test: Uncomment lines below and click card/icon to expand/collapse
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
//                    subTitle = "Here's the correct Material 3 way to make" +
//                            " ONLY the icon clickable using IconButton, " +
//                            "while the text stays non-clickable.",
//                )
//            }

            //====== 6: Google Sign Up Button ==========
            // Demonstrates: Custom button with loading state and animations
            // Currently active - Click button to see loading animation
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                GoogleButton() {
//                    Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
//                }
//            }

            //====== 7: Coil Image loader ==========
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//              //  CoilImageLoad()
//                CoilSubcomposeAsyncImage()
//            }


            //====== 8: Password Text Field ==========
            // Demonstrates: Material 3 OutlinedTextField with password visibility toggle
            // How to test: Currently active - Type password and click eye icon to toggle visibility
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                PasswordTextField()

                Spacer(modifier = Modifier.height(12.dp))

                //====== 9: Gradient Button ==========
                // Demonstrates: Custom button with gradient background using Brush
                // How to test: Click the gradient button to see the click handler
                GradientButton { }
            }
        }
    }
}

/**
 * Preview composable demonstrating modifier chaining
 * Shows how modifiers are applied in order (top to bottom)
 */
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
                .clickable {} // Applied first - makes entire area clickable
                .background(Color.Blue) // Applied second - blue background
                .size(200.dp) // Applied third - sets size
                .padding(36.dp) // Applied fourth - adds padding inside
                .clip(CircleShape) // Applied fifth - clips to circle
                .border(2.dp, color = Color.Red, shape = CircleShape) // Applied sixth - red border
                .background(color = Color.Yellow) // Applied last - yellow background (visible)

        )
        CircularImage()
    }
}

/**
 * Composable that displays a circular image with color filter
 * Demonstrates: Image composable, CircleShape clipping, ColorFilter
 */
@Composable
fun CircularImage() {
    Image(
        contentScale = ContentScale.Crop, // Crop image to fit bounds
        painter = painterResource(
            R.drawable.ic_launcher_foreground
        ),
        contentDescription = "", // Accessibility description
        modifier = Modifier
            .size(90.dp) // Set image size
            .clip(CircleShape), // Clip to circular shape
        colorFilter = ColorFilter.tint(Color.Red) // Apply red tint
    )
}

/**
 * Reusable list item composable
 * Displays an image with title and subtitle in a row layout
 * 
 * @param imageId Resource ID of the image to display
 * @param title Main text to display
 * @param subtitle Secondary text to display
 */
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

/**
 * Preview composable showing multiple list items
 * Demonstrates: Reusing ListViewItem composable
 */
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
