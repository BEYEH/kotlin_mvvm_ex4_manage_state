package com.example.kotlin_mvvm_ex4_manage_state.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText()
        MyTextField()
    }
}

@Composable
fun MyText() {
    Text(text = "Home Page", style = TextStyle(fontSize = 30.sp))
    Spacer(Modifier.height(30.dp))
    Text(text = "Name:")
}

@Composable
fun MyTextField() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = "Enter name") }
    )
}