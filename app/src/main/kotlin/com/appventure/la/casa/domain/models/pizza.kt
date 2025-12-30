package com.appventure.la.casa.domain.models

data class Pizza(
    val id: String,
    val name: String,
    val description: String = "",
    val rating: Int = 0,
    val offerTitle: String = "",
    val haveBtn: Boolean = true,
    val offerPercentage: Int = 0,
    val category: PizzaCategory,
    val basePrice: Int,
    val imageUrl: String,
    val sizes: Map<PizzaSize, Int>, //  price per size
    val defaultToppings: List<ToppingId>,
    val availableToppings: List<ToppingId> = emptyList(),
    val priority: Int,
    val isFeatured: Boolean,
    val isAvailable: Boolean
)
enum class PizzaCategory {
    CLASSIC, SPECIAL, VEGAN, SPICY
}

enum class PizzaSize {
    S, M, L
}
