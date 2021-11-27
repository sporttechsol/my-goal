package com.example.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.template.ui.home.HomeScreen
import com.example.template.ui.second.SecondScreen

@Composable
fun TemplateNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.HomeScreen.name
    ) {
        composable(NavigationRoute.HomeScreen.name) {
            HomeScreen()
        }
        composable(NavigationRoute.SecondScreen.name) {
            SecondScreen(navController = navController)
        }
//        val accountsName = Accounts.name
//        composable(
//            route = "$accountsName/{name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                }
//            ),
//            deepLinks = listOf(
//                navDeepLink {
//                    uriPattern = "rally://$accountsName/{name}"
//                }
//            ),
//        ) { entry ->
//            val accountName = entry.arguments?.getString("name")
//            val account = UserData.getAccount(accountName)
//            SingleAccountBody(account = account)
//        }
    }
}
