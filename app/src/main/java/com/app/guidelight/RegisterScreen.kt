package com.app.guidelight

import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Import MaterialTheme class
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegisterForm(onSubmitClick: ()-> Unit) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var selectedValidProof by remember { mutableStateOf("") }
    var validProofDetails by remember { mutableStateOf("") }

    var isEnglishKnown by remember { mutableStateOf(false) }
    var isTamilKnown by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )

        // Show the dropdown menu regardless of selected proof
        DropdownMenu(
            expanded = selectedValidProof.isNotEmpty(), // Can be expanded even without selection
            onDismissRequest = { selectedValidProof = "" },
            modifier = Modifier.fillMaxWidth() // Ensure correct modifier
        ) {
            DropdownMenuItem(
                onClick = { selectedValidProof = "Aadhar" },
                text = { Text("Aadhar") }
            )
            DropdownMenuItem(
                onClick = { selectedValidProof = "PAN" },
                text = { Text("PAN") }
            )
            DropdownMenuItem(
                onClick = { selectedValidProof = "Driving License" },
                text = { Text("Driving License") }
            )
        }

        // Conditionally show the valid proof details text field
        if (selectedValidProof.isNotEmpty()) {
            TextField(
                value = validProofDetails,
                onValueChange = { validProofDetails = it },
                label = { Text("Valid Proof Details ($selectedValidProof)") },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text(
                text = "Please select a valid proof type",
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row {
            Checkbox(
                checked = isEnglishKnown,
                onCheckedChange = { isEnglishKnown = it },
            )
            Text("English")
            Checkbox(
                checked = isTamilKnown,
                onCheckedChange = { isTamilKnown = it },
            )
            Text("Tamil")
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { onSubmitClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}