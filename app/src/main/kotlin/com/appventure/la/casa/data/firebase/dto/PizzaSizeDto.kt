package com.appventure.la.casa.data.firebase.dto


data class PizzaSizeDto(
    val pizzaId: String,
    val size: String,           // "S","M","L","XL"
    val extraPrice: Int
)