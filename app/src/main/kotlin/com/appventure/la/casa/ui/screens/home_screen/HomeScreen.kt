package com.appventure.la.casa.ui.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.appventure.la.casa.ui.screens.home_screen.components.BannerSection
import com.appventure.la.casa.ui.screens.home_screen.components.CategoriesSection
import com.appventure.la.casa.ui.screens.home_screen.components.PopularSection
import com.appventure.la.casa.ui.screens.home_screen.components.TopBarApp
//import com.appventure.la.casa.ui.screens.profile_screen.ProfileScreen
import com.appventure.la.casa.ui.theme.BackgroundLight
import org.koin.compose.viewmodel.koinViewModel


// --- (Data Models) ---
data class Category(val name: String, val icon: ImageVector, val isSelected: Boolean = false)
data class PizzaItem(val name: String, val description: String, val price: Double, val rating: Double, val image: String)
data class BannerItem(val badge: String, val title: String, val buttonTitle: String? = null, val image: String)

@Composable
fun HomeScreen(
    onProfileClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()


    Scaffold(
        modifier = Modifier.padding(top = 20.dp, start = 8.dp, end = 8.dp),
        containerColor = BackgroundLight,
        topBar = {
            TopBarApp(
                onProfileClick = onProfileClick,
                onNotificationsClick = onNotificationsClick
            )
        },
    ) { paddingValues ->
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                // Banner Section (Build Your Own & Limited Offer)
                item { BannerSection(uiState.banners) }

                // Categories Section
                item { CategoriesSection(uiState.categories) }

                // Popular Now Section
                item { PopularSection(uiState.popularItems) }
            }
        }
    }
}


/*@Preview(showBackground = true, widthDp = 360)
@Composable
fun AppPreview() {
    MainScreen()
}*/
