package com.example.template.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.template.ui.check.CheckScreen
import com.example.template.ui.profile.ProfileScreen
import com.example.template.ui.search.SearchScreen
import com.example.template.ui.skills.SkillsScreen
import com.example.template.ui.stats.StatsScreen
import com.example.template.ui.uploadvideo.UploadVideoScreen

@Composable
fun HomeNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigationRoute.ProfileScreen.name
    ) {
        composable(HomeNavigationRoute.ProfileScreen.name) {
            ProfileScreen()
        }
        composable(HomeNavigationRoute.SkillsScreen.name) {
            SkillsScreen(navController)
        }
        composable(HomeNavigationRoute.SearchScreen.name) {
            SearchScreen()
        }
        composable(HomeNavigationRoute.StatsScreen.name) {
            StatsScreen()
        }
        composable(HomeNavigationRoute.UploadVideoScreen.name) {
            UploadVideoScreen(navController = navController)
        }
        composable(HomeNavigationRoute.CheckScreen.name) {
            CheckScreen(navController = navController)
        }
    }
}
