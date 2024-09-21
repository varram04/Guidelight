package com.example.notifications

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.guidelight.data.NotificationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(notifications: List<NotificationItem>) {
    Scaffold(topBar = { TopAppBar(title = { Text("Notifications") }) }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            items(notifications.size) { index ->
                NotificationCard(notifications[index])
            }
        }
    }

}

@Composable
fun NotificationCard(notification: NotificationItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = notification.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = notification.message, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = notification.time, style = MaterialTheme.typography.bodySmall)
        }
    }
}
