package com.example.template.ui.uploadvideo

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun UploadVideoScreen(
    navController: NavController,
    viewModel: UploadVideoViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Upload video") }) }
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.value.videoUrl,
                onValueChange = { viewModel.setVideoUrl(it) },
                label = { Text(text = "Link") }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Text(text = "Submit")
            }
        }
    }
}
