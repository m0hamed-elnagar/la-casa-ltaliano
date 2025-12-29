package com.android.la.casa.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.la.casa.ui.components.home_screen.BannerSection
import com.android.la.casa.ui.components.home_screen.BottomAppBar
import com.android.la.casa.ui.components.home_screen.CategoriesSection
import com.android.la.casa.ui.components.home_screen.PopularSection
import com.android.la.casa.ui.components.home_screen.TopBarApp
import com.android.la.casa.ui.theme.*


// --- (Data Models) ---
data class Category(val name: String, val icon: ImageVector, val isSelected: Boolean = false)
data class PizzaItem(val name: String, val description: String, val price: Double, val rating: Double, val image: String)
data class BannerItem(val badge: String, val title: String, val buttonTitle: String?=null, val image: String)


@Composable
fun HomeScreen() {
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