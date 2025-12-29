package com.appventure.la.casa.domain.models

data class FavPizza(
    val id: String,
    val userId: String,
    val pizzaId: String,
    val toppings: List<String>,
    val size: String,
    val lastUpdated: Long
)
