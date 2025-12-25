package com.appventure.la.casa.domain.models

data class OrderItem(
    val pizzaId: String,
    val pizzaName: String,
    val size: PizzaSize,
    val quantity: Int,
    val selectedToppings: List<ToppingSnapshot>,
    val unitPrice: Int,
    val notes : String
)
data class ToppingSnapshot(
    val id: ToppingId,
    val name: String,
    val price: Int
)
