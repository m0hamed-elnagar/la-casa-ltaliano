package com.appventure.la.casa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class AppNavigationState(
    val navController: NavHostController,
) {
    val currentRoute: String?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route


    fun navigateToTopLevel(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateTo(route: String) {
        navController.navigate(route)
    }
}

@Composable
fun rememberAppNavigationState(
    navController: NavHostController = rememberNavController(),
): AppNavigationState {
    return remember(navController) {
        AppNavigationState(navController)
    }
}
