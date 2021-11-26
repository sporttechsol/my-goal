package com.example.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.template.ui.first.FirstScreen
import com.example.template.ui.second.SecondScreen

@Composable
fun TemplateNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.FirstScreen.name
    ) {
        composable(NavigationRoute.FirstScreen.name) {
            FirstScreen(navController = navController)
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
