package com.appventure.la.casa.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appventure.la.casa.R
import com.appventure.la.casa.ui.screens.home_screen.components.BottomAppBar
import com.appventure.la.casa.ui.screens.home_screen.components.NavItem
import com.appventure.la.casa.ui.screens.home_screen.HomeScreen
//import com.appventure.la.casa.ui.screens.profile_screen.ProfileScreen
import com.appventure.la.casa.ui.theme.BackgroundLight

@Composable
fun AppNavGraph(
    navState: AppNavigationState = rememberAppNavigationState()
) {
    val navItems = listOf(
        NavItem("Home", Routes.HOME, R.drawable.ic_home_fill, R.drawable.ic_home_outlined),
        NavItem("Favorite", Routes.FAVORITE, R.drawable.ic_favorite_fill, R.drawable.ic_favorite_outlined),
        NavItem("Orders", Routes.ORDER, R.drawable.ic_moped_fill, R.drawable.ic_moped_outlined),
        NavItem("Category", Routes.CATEGORY, R.drawable.ic_category_fill, R.drawable.ic_category_outlined)
    )

    val currentRoute = navState.currentRoute

    Scaffold(
        containerColor = BackgroundLight,
        bottomBar = {
            // Show BottomAppBar on main screens only
            if (currentRoute in listOf(Routes.HOME, Routes.FAVORITE, Routes.ORDER, Routes.CATEGORY)) {
                BottomAppBar(
                    items = navItems,
                    currentRoute = currentRoute.toString(),
                    onItemClick = { navState.navigateToTopLevel(it) },
                    onCartClick = { navState.navigateTo(Routes.CART) }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navState.navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(paddingValues),
            enterTransition = { slideInVertically { it } },
            exitTransition = { fadeOut() },
            popEnterTransition = { fadeIn() },
            popExitTransition = { slideOutVertically { it } }
        ) {
            // Main navigation routes
            composable(Routes.HOME) { HomeScreen({navState.navigateTo(Routes.PROFILE)}, {navState.navigateTo(Routes.NOTIFICATION)}) }
            composable(Routes.FAVORITE) { PlaceholderScreen("Favorite") }
            composable(Routes.ORDER) { PlaceholderScreen("Orders") }
            composable(Routes.CATEGORY) { PlaceholderScreen("Category") }

            // Other routes accessible from different parts of the app
            composable(Routes.PROFILE) { /*ProfileScreen()*/ }
            composable(Routes.CART) { PlaceholderScreen("Cart") }
            composable(Routes.NOTIFICATION) { PlaceholderScreen("Notification") }
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
