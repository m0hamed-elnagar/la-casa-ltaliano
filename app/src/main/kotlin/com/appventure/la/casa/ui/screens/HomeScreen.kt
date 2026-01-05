package com.appventure.la.casa.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appventure.la.casa.ui.components.home_screen.BannerSection
import com.appventure.la.casa.ui.components.home_screen.BottomAppBar
import com.appventure.la.casa.ui.components.home_screen.CategoriesSection
import com.appventure.la.casa.ui.components.home_screen.PopularSection
import com.appventure.la.casa.ui.components.home_screen.TopBarApp
import com.appventure.la.casa.ui.theme.BackgroundLight
import org.koin.compose.viewmodel.koinViewModel


// --- (Data Models) ---
data class Category(val name: String, val icon: ImageVector, val isSelected: Boolean = false)
data class PizzaItem(val name: String, val description: String, val price: Double, val rating: Double, val image: String)
data class BannerItem(val badge: String, val title: String, val buttonTitle: String?=null, val image: String)


@Composable
fun HomeScreen(
    viewModel: HomeVM = koinViewModel()


) {


    Scaffold(
        modifier = Modifier.padding(top = 20.dp, start = 8.dp, end = 8.dp),
        containerColor = BackgroundLight,
        topBar = { TopBarApp()},
        bottomBar = { BottomAppBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            // Banner Section (Build Your Own & Limited Offer)
            item { BannerSection() }

            // Categories Section
            item { CategoriesSection() }

            // Popular Now Section
            item { PopularSection() }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun AppPreview() {
    HomeScreen()
}