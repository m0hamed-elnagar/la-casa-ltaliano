package com.appventure.la.casa.domain.models

sealed interface SyncState {
    data object Idle : SyncState
    data object Running : SyncState
    data object Success : SyncState
    data class Failed(val msg: String?) : SyncState
}

enum class SyncTarget {
    PIZZAS,
    SIZES,
    TOPPINGS
}
