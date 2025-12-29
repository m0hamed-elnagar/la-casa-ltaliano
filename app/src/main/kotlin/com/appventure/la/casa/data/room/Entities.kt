package com.appventure.la.casa.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/* ====== Pizza ====== */
@Entity(tableName = "pizzas")
data class Pizza(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
    val description: String,
    val category: String,
    val basePrice: Int,      // cents for size M
    val imageUrl: String,
    val localPath : String?,
    val defaultToppings: List<String>,   // ToppingId
    val availableToppings: List<String>, // ToppingId
    val priority: Int,
    val isFeatured: Boolean,
    val isAvailable: Boolean,
    val lastUpdated: Long
)
@Entity(tableName = "toppings")
data class Topping(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
    val price: Int,    // In cents (e.g., 100 for $1.00)
    val inStock: Boolean,
    val imageUrl: String,
    val localPath : String?,

    )

@Entity(
    tableName = "pizza_sizes",
    primaryKeys = ["pizzaId", "size"]
)
data class PizzaSizeEntity(
    val pizzaId: String,
    val size: String,     // "S", "M", "L", "XL"
    val extraPrice: Int   // relative to basePrice
)

@Entity(tableName = "menu_metadata")
data class MenuMetadataEntity(
    @PrimaryKey val id: Int = 0,          // single row
    val version: Int,
    val lastUpdated: Long
)