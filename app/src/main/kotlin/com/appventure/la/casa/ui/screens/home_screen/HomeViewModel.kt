package com.appventure.la.casa.ui.screens.home_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.material.icons.rounded.Icecream
import androidx.compose.material.icons.rounded.LocalDrink
import androidx.compose.material.icons.rounded.LunchDining
import androidx.compose.material.icons.rounded.Tapas
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appventure.la.casa.domain.use_cases.pizza.ObservePizzaUseCase
import com.appventure.la.casa.domain.use_cases.pizza.SyncPizzaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Define the UI State data class
data class HomeUiState(
    val banners: List<PizzaDto> = emptyList(),
    val categories: List<Category> = emptyList(),
    val popularItems: List<PizzaItem> = emptyList(),
    val isLoading: Boolean = true,
)

// Create the ViewModel
class HomeViewModel(
    private val observePizzaUseCase: ObservePizzaUseCase,
    private val syncPizzaUseCase: SyncPizzaUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {

        viewModelScope.launch {
            try {
                syncPizzaUseCase()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // Start observing the local database for changes.
        // This will show initial cached data and then update automatically after the sync is complete.
        observePizzaUseCase().onEach { pizzas ->
            _uiState.update { viewState ->
                val popular = pizzas.map {
                    PizzaItem(
                        name = it.name,
                        description = it.description,
                        price = it.basePrice.toDouble(),
                        rating = it.rating.toDouble(),
                        image = it.imageUrl
                    )
                }

                viewState.copy(
                    popularItems = popular,
                    isLoading = false,
                    banners = createDummyBanners(),
                    categories = createDummyCategories(),
                )
            }
        }.launchIn(viewModelScope)
    }
}

// Temporary dummy data functions - ideally these would also come from use cases
private fun createDummyBanners(): List<PizzaDto> {
    return listOf(
        PizzaDto(
            id = "custom_pizza_01", name = "Build Your Own Pizza", description = "Choose your favorite crust and toppings",
            rating = 5, offerTitle = "Create your perfect pizza from scratch!", offerPercentage = 0, haveBtn = true,
            category = "Start Building", basePrice = 150, imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=600",
            defaultToppings = listOf("Tomato sauce", "Mozzarella"),
            availableToppings = listOf("Bacon", "Pepperoni", "Mushrooms", "Jalapeños", "Extra Cheese"),
            priority = 1, isAvailable = true
        ),
        PizzaDto(
            id = "promo_half_price", name = "Double Delight Deal", description = "Order one and get the second at half price",
            rating = 4, offerTitle = "50% OFF on your second pizza!", offerPercentage = 50, haveBtn = true,
            category = "Order Now", basePrice = 280, imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=600",
            defaultToppings = listOf("Tomato sauce", "Mozzarella", "Pepperoni"), availableToppings = listOf("Olives", "Green Pepper"),
            priority = 2, isAvailable = true
        ),
    )
}

private fun createDummyCategories(): List<Category> {
    return listOf(
        Category("Pizza", Icons.Outlined.LocalPizza, isSelected = true),
        Category("Burger", Icons.Rounded.LunchDining),
        Category("Drinks", Icons.Rounded.LocalDrink),
        Category("Sides", Icons.Rounded.Tapas),
        Category("Sweets", Icons.Rounded.Icecream),
    )
}

data class PizzaDto(
    val id: String, val name: String, val description: String, val rating: Int,
    val offerTitle: String, val offerPercentage: Int, val haveBtn: Boolean,
    val category: String, val basePrice: Int, val imageUrl: String,
    val defaultToppings: List<String>, val availableToppings: List<String>,
    val priority: Int, val isAvailable: Boolean
)
