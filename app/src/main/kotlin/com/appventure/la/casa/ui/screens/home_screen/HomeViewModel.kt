package com.appventure.la.casa.ui.screens.home_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalDrink
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Tapas
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// 1. Define the UI State data class
data class HomeUiState(
    val banners: List<PizzaDto> = emptyList(),
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
            /*val dummyBanners = listOf(
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

            PizzaDto(
                id = "LIMITED OFFER",
                name = "LIMITED OFFER",
                description = "Order Now",
                rating = 0,
                offerTitle = "50% off on your second pizza!",
                offerPercentage = 0,
                haveBtn = true,
                category = "Classics",
                basePrice = 999,
                imageUrl = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?w=500",
                defaultToppings = listOf("Tomato sauce", "Mozzarella"),
                availableToppings = listOf("Bacon", "Cherry tomatoes", "Jalapeños"),
                priority = 2,
                isAvailable = true
            )*/

            val dummyBanners = listOf(
                // Build Your Own
                PizzaDto(
                    id = "custom_pizza_01",
                    name = "Build Your Own Pizza",
                    description = "Choose your favorite crust and toppings",
                    rating = 5,
                    offerTitle = "Create your perfect pizza from scratch!",
                    offerPercentage = 0,
                    haveBtn = true,
                    category = "Start Building",
                    basePrice = 150,
                    imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=600",
                    defaultToppings = listOf("Tomato sauce", "Mozzarella"),
                    availableToppings = listOf("Bacon", "Pepperoni", "Mushrooms", "Jalapeños", "Extra Cheese"),
                    priority = 1,
                    isAvailable = true
                ),

                // Half Price Deal
                PizzaDto(
                    id = "promo_half_price",
                    name = "Double Delight Deal",
                    description = "Order one and get the second at half price",
                    rating = 4,
                    offerTitle = "50% OFF on your second pizza!",
                    offerPercentage = 50,
                    haveBtn = true,
                    category = "Order Now",
                    basePrice = 280,
                    imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=600",
                    defaultToppings = listOf("Tomato sauce", "Mozzarella", "Pepperoni"),
                    availableToppings = listOf("Olives", "Green Pepper"),
                    priority = 2,
                    isAvailable = true
                ),

                // Family Combo
                PizzaDto(
                    id = "family_combo_20",
                    name = "The Big Feast",
                    description = "Two large pizzas for a great price",
                    rating = 5,
                    offerTitle = "2 Large Pizzas for only $20",
                    offerPercentage = 25,
                    haveBtn = true,
                    category = "Order Now",
                    basePrice = 600,
                    imageUrl = "https://images.unsplash.com/photo-1593560704563-f176a2eb61db?w=600",
                    defaultToppings = listOf("Tomato sauce", "Mozzarella", "Chicken"),
                    availableToppings = listOf("BBQ Sauce", "Onions"),
                    priority = 3,
                    isAvailable = true
                ),

                // Summer Lunch
                PizzaDto(
                    id = "summer_lunch_deal",
                    name = "Summer Lunch Special",
                    description = "Light meal for a sunny day",
                    rating = 4,
                    offerTitle = "Summer Lunch: Free Drink + Pizza",
                    offerPercentage = 15,
                    haveBtn = false,
                    category = "Classics",
                    basePrice = 120,
                    imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=600",
                    defaultToppings = listOf("Tomato sauce", "Mozzarella", "Veggies"),
                    availableToppings = listOf("Sweet Corn", "Cherry tomatoes"),
                    priority = 4,
                    isAvailable = true
                ),

                // Salad Offer
                PizzaDto(
                    id = "salad_promo_30",
                    name = "Fresh Garden Salads",
                    description = "Freshly picked ingredients for a healthy side",
                    rating = 5,
                    offerTitle = "30% OFF on all Green Salads!",
                    offerPercentage = 30,
                    haveBtn = false,
                    category = "Salads",
                    basePrice = 80,
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=600",
                    defaultToppings = listOf("Lettuce", "Cucumber", "Dressing"),
                    availableToppings = listOf("Grilled Chicken", "Feta Cheese", "Walnuts"),
                    priority = 5,
                    isAvailable = true
                )
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

data class PizzaDto(
    val id: String,
    val name: String,
    val description: String,
    val rating: Int,
    val offerTitle: String,
    val offerPercentage: Int,
    val haveBtn: Boolean,
    val category: String,
    val basePrice: Int,
    val imageUrl: String,
    val defaultToppings: List<String>,
    val availableToppings: List<String>,
    val priority: Int,
    val isAvailable: Boolean
) {

}
