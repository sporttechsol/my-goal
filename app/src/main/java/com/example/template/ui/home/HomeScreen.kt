package com.example.template.ui.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    val navController = rememberNavController()
    val secondTab = if (state.value.isPlayer) {
        BottomNavigationItem.Skills
    } else {
        BottomNavigationItem.Check
    }
    val items = listOf(
        BottomNavigationItem.Profile,
        secondTab,
        BottomNavigationItem.Search,
        BottomNavigationItem.Stats,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
            ) {
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.route.name,
                        selectedContentColor = MaterialTheme.colors.primary,
                        onClick = {
                            navController.navigate(item.route.name) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = stringResource(id = item.title)) },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = stringResource(id = item.title)
                            )
                        }
                    )
                }
            }
        }
    ) {
        HomeNavHost(navController = navController)
    }
}
