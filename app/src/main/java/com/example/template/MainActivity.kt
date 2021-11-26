package com.example.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.template.navigation.TemplateNavHost
import com.example.template.ui.theme.TemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateApp()
        }
    }
}

@Composable
fun TemplateApp() {
    TemplateTheme {
        val navController = rememberNavController()

        TemplateNavHost(navController = navController)
    }
}
