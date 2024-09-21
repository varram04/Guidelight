package com.app.guidelight

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DashboardScreen() {

    val exams by remember {
        mutableStateOf(
            mapOf(
                "Sep, 22" to listOf(
                    Exam("Math", "Sep, 12", "10:00 AM"),
                    Exam("Math", "Sep, 12", "10:00 AM"),
                    Exam("Math", "Sep, 12", "10:00 AM")
                ),
                "Sep, 23" to listOf(
                    Exam("Math", "Sep, 12", "10:00 AM"),
                    Exam("Math", "Sep, 12", "10:00 AM")
                ),
                "Sep, 28" to listOf(
                    Exam("Math", "Sep, 12", "10:00 AM"),
                    Exam("Math", "Sep, 12", "10:00 AM")
                )
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Dashboard") }) }) { paddingValues ->
        ExamItems(modifier = Modifier.padding(paddingValues), examsByDate = exams)
    }
}


data class Exam(
    val subject: String,
    val date: String,
    val time: String
)

@Composable
fun CourseItems(modifier: Modifier, courses:Map<String,Map<String,List<Exam>>>){
    var expanded by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        courses.forEach { (name, exams) ->
            item {
                Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(vertical = 8.dp)
            )
                if (expanded) {
                    ExamItems(modifier = Modifier, examsByDate = exams)
                }
            }
        }
    }
}

@Composable
fun ExamItems(modifier: Modifier, examsByDate: Map<String, List<Exam>>) {
    LazyColumn(
        modifier = modifier.
        fillMaxSize()
            .padding(16.dp)
    ) {
        examsByDate.forEach { (date, exams) ->
            // Section Header (Date)
            item {
                Text(
                    text = date,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // List of exams for each date
            items(exams) { exam ->
                ExamItem(exam)
            }
        }
    }
}



@Composable
fun ExamItem(exam: Exam) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = exam.subject, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${exam.date} at ${exam.time}", fontSize = 14.sp)
            }

            // Apply Button
            Button(
                onClick = { /* Handle Apply Action */ },
                modifier = Modifier.alignByBaseline()
            ) {
                Text(text = "Apply")
            }
        }
    }
}
