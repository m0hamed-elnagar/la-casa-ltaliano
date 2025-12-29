package com.appventure.la.casa.data.firebase.dto

data class ToppingDto(
    val id: String,
    val name: String,
    val price: Int,                 // cents
    val inStock: Boolean,
    val imageUrl: String
)