package com.example.template.ui.home

import com.example.template.R

sealed class BottomNavigationItem(val route: HomeNavigationRoute, val icon: Int, val title: Int) {
    object Profile : BottomNavigationItem(
        route = HomeNavigationRoute.ProfileScreen,
        icon = R.drawable.ic_baseline_person_24,
        title = R.string.bottom_navigation_profile_title
    )
    object Skills : BottomNavigationItem(
        route = HomeNavigationRoute.SkillsScreen,
        icon = R.drawable.ic_baseline_assignment_turned_in_24,
        title = R.string.bottom_navigation_skills_title
    )
    object Search :  BottomNavigationItem(
        route = HomeNavigationRoute.SearchScreen,
        icon = R.drawable.ic_baseline_search_24,
        title = R.string.bottom_navigation_search_title
    )
    object Stats : BottomNavigationItem(
        route = HomeNavigationRoute.StatsScreen,
        icon = R.drawable.ic_baseline_auto_graph_24,
        title = R.string.bottom_navigation_stats_title
    )
    object Check : BottomNavigationItem(
        route = HomeNavigationRoute.CheckScreen,
        icon = R.drawable.ic_baseline_check_circle_24,
        title = R.string.bottom_navigation_check_title
    )
}
