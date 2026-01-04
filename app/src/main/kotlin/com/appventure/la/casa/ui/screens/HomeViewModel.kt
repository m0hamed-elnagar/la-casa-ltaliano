package com.appventure.la.casa.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalFireDepartment
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalDrink
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Tapas
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appventure.la.casa.R
import com.appventure.la.casa.ui.screens.BannerItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// 1. Define the UI State data class
data class HomeUiState(
    val banners: List<BannerItem> = emptyList(),
    val categories: List<Category> = emptyList(),
    val popularItems: List<PizzaItem> = emptyList(),
    val isLoading: Boolean = true
)

// 2. Create the ViewModel
class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        // Fetch data when the ViewModel is created
        fetchHomeScreenData()
    }

    private fun fetchHomeScreenData() {
        viewModelScope.launch {
            // In a real app, you would fetch this from a repository
            val dummyBanners = listOf(
                BannerItem(
                    badge = "Build Your Own",
                    title = "Create your perfect pizza from scratch!",
                    buttonTitle = "Order Now",
                    image = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=500"
                ),
                BannerItem(
                    badge = "Limited Offer",
                    title = "50% off on your second pizza!",
                    image = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?w=500"
                ),
                BannerItem (
                        "CUSTOMIZE",
                "Build Your\nOwn Pizza",
                "Start Building",
                "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500&auto=format&fit=crop&q=60"
            ),
            BannerItem(
                "LIMITED OFFER",
                "2 Large Pizzas \nFor Only $20",
                "Order Now",
                "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500"
            ),
            BannerItem(
                "LIMITED OFFER",
                "Summer Lunch\n" +
                        "Deal",
                null,
                "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500"
            ),
            )

            val dummyCategories = listOf(
                Category("Pizza", Icons.Outlined.LocalPizza, isSelected = true),
                Category("Burger", Icons.Rounded.LunchDining),
                Category("Drinks", Icons.Rounded.LocalDrink),
                Category("Sides", Icons.Rounded.Tapas),
                Category("Sweets", Icons.Rounded.Icecream),
            )

            val dummyPopularItems = listOf(
                PizzaItem(
                    "Double Pepperoni",
                    "Extra mozzarella, pepperoni",
                    14.50,
                    4.8,
                    "https://images.unsplash.com/photo-1628840042765-356cda07504e?w=500"
                ),
                PizzaItem(
                    "Veggie Supreme",
                    "Bell peppers, olives, onion",
                    12.00,
                    4.5,
                    "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=500"
                ),
                PizzaItem(
                    "BBQ Chicken",
                    "BBQ sauce, chicken, onions",
                    15.50,
                    4.9,
                    "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=500"
                )
            )

            // Update the state
            _uiState.update {
                it.copy(
                    banners = dummyBanners,
                    categories = dummyCategories,
                    popularItems = dummyPopularItems,
                    isLoading = false
                )
            }
        }
    }
}