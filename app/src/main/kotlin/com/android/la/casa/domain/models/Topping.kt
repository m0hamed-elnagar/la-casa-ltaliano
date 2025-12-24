package com.android.la.casa.domain.models

data class Topping(
    val id: ToppingId,
    val name: String,
    val price: Int,
    val imageUrl: String,
    val isAvailable: Boolean
)

typealias ToppingId = String
