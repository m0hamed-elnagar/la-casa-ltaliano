package com.appventure.la.casa.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.appventure.la.casa.R
import com.appventure.la.casa.ui.components.home_screen.BottomAppBar
import com.appventure.la.casa.ui.components.home_screen.NavItem
import com.appventure.la.casa.ui.screens.profile_screen.ProfileScreen
import com.appventure.la.casa.ui.theme.BackgroundLight

@Composable
fun RoutesManger() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navItems = listOf(
        NavItem("Home", "home", R.drawable.ic_home_fill, R.drawable.ic_home_outlined),
        NavItem("Favorite", "favorite", R.drawable.ic_favorite_fill, R.drawable.ic_favorite_outlined),
        NavItem("Orders", "orders", R.drawable.ic_moped_fill, R.drawable.ic_moped_outlined),
        NavItem("Category", "category", R.drawable.ic_category_fill, R.drawable.ic_category_outlined)
    )

    Scaffold(
        containerColor = BackgroundLight,
        bottomBar = {
            if (currentRoute != "cart" && currentRoute != "notification" && currentRoute != "profile") {
                BottomAppBar(
                    items = navItems,
                    currentRoute = currentRoute ?: "home",
                    onItemClick = {
                        navController.navigate(it) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    onCartClick = { navController.navigate("cart") }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            // Main navigation routes
            composable("home") { HomeScreen(navController) }
            composable("favorite") { PlaceholderScreen("Favorite") }
            composable("orders") { PlaceholderScreen("Orders") }
            composable("category") { PlaceholderScreen("Category") }

            // Other routes accessible from different parts of the app
            composable("profile") { ProfileScreen() }
            composable("cart") { PlaceholderScreen("Cart") }
            composable("notification") { PlaceholderScreen("Notification") }
            // composable("product_details/{productId}") { backStackEntry ->
            //     val productId = backStackEntry.arguments?.getString("productId")
            //     ProductDetailsScreen(productId = productId)
            // }
        }
    }
}

@Composable
fun PlaceholderScreen(screenName: String) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(text = "$screenName Screen")
        }
    }
}