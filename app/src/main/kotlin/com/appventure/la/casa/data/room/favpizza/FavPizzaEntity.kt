package com.appventure.la.casa.data.room.favpizza

import androidx.room.Entity

@Entity(
    tableName = "fav_pizza",
    primaryKeys = ["id", "pizzaId"]
)
data class FavPizzaEntity(
    val id: String,
    val pizzaId: String,
    val toppings : List<String>,
    val size : String,
    val lastUpdated: Long // Use System.currentTimeMillis()
)