package com.appventure.la.casa.data.room.menu

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

/* ====== Pizza ====== */
@Entity(tableName = "pizzas")
data class PizzaEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
    val description: String,
    val category: String,
    val basePrice: Int,      // cents for size M
    val imageUrl: String,
    val defaultToppings: List<String>,   // ToppingId
    val availableToppings: List<String>, // ToppingId
    val priority: Int,
    val isFeatured: Boolean,
    val isAvailable: Boolean,
    val lastUpdated: Long
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
//one to many relation
data class PizzaWithSizes(
    @Embedded val pizza: PizzaEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "pizzaId"
    )
    val sizes: List<PizzaSizeEntity>
)

@Entity(tableName = "toppings")
data class ToppingEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
    val price: Int,    // In cents (e.g., 100 for $1.00)
    val inStock: Boolean,
    val imageUrl: String,
)