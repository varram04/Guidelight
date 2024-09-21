package com.app.guidelight

import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Import MaterialTheme class
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
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

    Scaffold(topBar = { TopAppBar(title = { Text("Register") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
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
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
            ProofDropdown()
            // Show the dropdown menu regardless of selected proof

            Text(modifier = Modifier.padding(top = 8.dp), text = "Please Select know languages")
            Row(modifier = Modifier.padding(top = 4.dp).align(Alignment.Start)) {
                Checkbox(
                    modifier = Modifier.align(Alignment.CenterVertically),
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
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { onSubmitClick() },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }



}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProofDropdown() {
    // List of proof types
    val proofs = listOf("Passport", "Driver's License", "ID Card", "Social Security Card")

    // State to keep track of the selected proof and whether the dropdown is expanded
    var selectedProof by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    // Exposed Dropdown Menu Box for managing the dropdown
    ExposedDropdownMenuBox(
        modifier = Modifier.padding(top = 8.dp),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        // TextField displaying the selected proof
        TextField(
            value = selectedProof,
            onValueChange = { },
            readOnly = true,
            label = { Text("Select Proof") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor() // Ensures the dropdown is positioned correctly
        )

        // Dropdown menu content
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            proofs.forEach { proof ->
                DropdownMenuItem(
                    text = { Text(proof) },
                    onClick = {
                        selectedProof = proof // Update selected proof
                        expanded = false // Close the dropdown
                    }
                )
            }
        }
    }
}