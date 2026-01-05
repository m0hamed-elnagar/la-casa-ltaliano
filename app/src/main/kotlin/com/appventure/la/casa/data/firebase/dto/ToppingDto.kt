package com.appventure.la.casa.data.firebase.dto

data class ToppingDto(
    val id: String="",
    val name: String="",
    val price: Long = 0L,                 // cents
    val inStock: Boolean = true,
    val imageUrl: String = ""
)