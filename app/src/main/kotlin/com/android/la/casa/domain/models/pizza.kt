package com.android.la.casa.domain.models

data class Pizza(
    val id: String,
    val name: String,
    val description: String,
    val category: PizzaCategory,
    val basePrice: Int,
    val imageUrl: String,
    val sizes: Map<PizzaSize, Int>, // incremental price per size
    val defaultToppings: List<ToppingId>,
    val availableToppings: List<ToppingId>,
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
