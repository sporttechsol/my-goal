package com.example.template.ui.skills

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.template.ui.home.HomeNavigationRoute

@Composable
fun SkillsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "My Skills")})
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Button(
                onClick = { navController.navigate(HomeNavigationRoute.UploadVideoScreen.name) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Running 15m")
            }
            Button(
                onClick = { navController.navigate(HomeNavigationRoute.UploadVideoScreen.name) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Running 50m")
            }
            Button(
                onClick = { navController.navigate(HomeNavigationRoute.UploadVideoScreen.name) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Running 100m")
            }
        }
    }
}
