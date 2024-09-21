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
import com.app.guidelight.ui.theme.GuidelightTheme
import com.example.notifications.NotificationScreen

class MainActivity : ComponentActivity() {
    val sampleNotifications = listOf(
        NotificationItem("Reminder 1", "You have a meeting at 10 AM", "10:00 AM"),
        NotificationItem("Reminder 2", "Call with the client", "2:00 PM"),
        NotificationItem("Reminder 3", "Finish the report", "5:00 PM")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuidelightTheme {
               RegisterForm()
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