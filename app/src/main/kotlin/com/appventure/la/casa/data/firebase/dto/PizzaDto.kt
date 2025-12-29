package com.appventure.la.casa.data.firebase.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/* ========== Topping ========== */
@Serializable                        // ❌ no Room annotations here
data class ToppingDto(
    val id: String,
    val name: String,
    val price: Int,                 // cents
    val inStock: Boolean,
    val imageUrl: String
)

/* ========== Pizza ========== */
@Serializable
data class PizzaDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val basePrice: Int,
    val imageUrl: String,
    val defaultToppings: List<String> = emptyList(),
    val availableToppings: List<String> = emptyList(),
    val priority: Int,
    val isFeatured: Boolean,
    val isAvailable: Boolean,
    val lastUpdated: Long
)

/* ========== Size ========== */
@Serializable
data class PizzaSizeDto(
    val pizzaId: String,
    val size: String,           // "S","M","L","XL"
    val extraPrice: Int
)

/* ========== Firestore wrapper ========== */
@Serializable
data class MenuDocument(
    val data: List<JsonObject>,        // mixed array of the three DTOs
    val updatedAt: Long = System.currentTimeMillis(),
    val version: Int
)