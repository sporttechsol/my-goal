package com.example.template.ui.first

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.template.navigation.NavigationRoute

@Composable
fun FirstScreen(
    navController: NavController,
    viewModel: FirstViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        val state = viewModel.state.collectAsState()

        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            TextField(
                value = state.value.name,
                onValueChange = { viewModel.onNameChanged(it) },
                placeholder = { Text(text = "Enter your name")}
            )
            Text(text = "Hello, ${state.value.name}!!!")
            Text(text = "Click the button to go to second screen")
            Button(onClick = { navController.navigate(NavigationRoute.SecondScreen.name)}) {
                Text(text = "Second Screen")
            }
        }
    }
}
