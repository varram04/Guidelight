package com.app.guidelight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.guidelight.data.NotificationItem
import com.app.guidelight.ui.navigation.AppNavigation
import com.app.guidelight.ui.theme.GuidelightTheme
import com.example.notifications.NotificationScreen

class MainActivity : ComponentActivity() {
    val sampleNotifications = listOf(
        NotificationItem("Exam date announcement", "The reporting time for the registered exam is 9:00 AM", "10:00 AM"),
        NotificationItem("Confirmation", "you are successfully registered", "2:00 PM"),
        NotificationItem("Cancellation", "Registration for the exam has been successfully canceled", "5:00 PM"),
        NotificationItem("Unsuccessful registration", "Your registration has been declined ,Please try again", "6:00 PM"),
        NotificationItem("Announcement", "volunteers required for x courses", "5:00 PM")


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuidelightTheme {
               AppNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuidelightTheme {
        Greeting("Android")
    }
}