package com.appventure.la.casa.domain.repo

import com.android.la.casa.domain.models.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    /* Create order ; returns orderId immediately (local first) */
    suspend fun placeOrder(order: Order): String

    /* Real-time status of a single order */
    fun observeOrder(orderId: String): Flow<Order?>

    /* Paginated history for “My orders” screen */
    fun observeOrderHistory(userId: String, limit: Long = 20): Flow<List<Order>>

    /* Allow user to mark delivered (status == DELIVERED) */
    suspend fun acknowledgeDelivery(orderId: String)

    /* Retry upload if previous placeOrder failed (worker calls this) */
    suspend fun syncPendingOrders()
}