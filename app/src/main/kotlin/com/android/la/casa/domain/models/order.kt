package com.android.la.casa.domain.models

data class Order(
    val id: String,
    val userId: String,
    val status: OrderStatus,
    val items: List<OrderItem>,
    val totalPrice: Int,
    val createdAt: Long
)
enum class OrderStatus {
    CONFIRMED,
    PREPARING,
    BAKING,
    ON_THE_WAY,
    DELIVERED
}
