package com.appventure.la.casa.data.firebase.dto

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp

data class PizzaDto(
    val id: String = "",
    val name: String = "",
    val description: String = "",
     val rating: Int = 0,
    val offerTitle: String = "",
    val haveBtn: Boolean = true,
    val offerPercentage: Int = 0,
    val category: String = "",
    val basePrice: Long = 0,
    val imageUrl: String = "",
    val defaultToppings: List<String> = emptyList(),
    val availableToppings: List<String> = emptyList(),
    val priority: Long = 0,
    val isFeatured: Boolean = false,
    val isAvailable: Boolean = true,
    @ServerTimestamp
    val lastUpdated: Timestamp? = null   // Firestore writes the server time
)