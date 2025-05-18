package com.example.kotlin_mvvm_ex4_manage_state.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_mvvm_ex4_manage_state.ViewModel.HomePageViewModel

@Composable
fun HomePage(viewModel: HomePageViewModel) {
    Log.i("HomePage", "is called.")

    var name by remember {
        mutableStateOf("")
    }

    var nameSaveable by rememberSaveable {
        mutableStateOf("")
    }

    val nameLiveData by viewModel.name.observeAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Page", style = TextStyle(fontSize = 30.sp))
        Spacer(Modifier.height(30.dp))

        // remember: persist state on recomposition
        Text(text = "Remember variable")
        MyText(name)
        MyTextField(name, onNameChange = {
            name = it
        })
        Spacer(Modifier.height(30.dp))

        // rememberSaveable: persist even on configuration changes
        Text(text = "RememberSaveable variable")
        MyText(nameSaveable)
        MyTextField(nameSaveable, onNameChange = {
            nameSaveable = it
        })
        Spacer(Modifier.height(30.dp))

        /**
         * ViewModel and Livedata:
         * Persist even on configuration changes.
         * Host the state for reusable and testable.
         */
        Text(text = "ViewModel and Livedata variable")
        MyText(nameLiveData)
        MyTextField(nameLiveData, onNameChange = {
            viewModel.onNameUpdate(it)
        })
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun MyText(name: String) {
    Text(text = "Name: $name")
}

@Composable
fun MyTextField(name: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text(text = "Enter name") }
    )
}
