package com.appventure.la.casa.data.mappers

import com.appventure.la.casa.data.room.favpizza.FavPizzaEntity
import com.appventure.la.casa.domain.models.FavPizza

fun FavPizzaEntity.toDomain(): FavPizza {
    return FavPizza(
        id = id,
        pizzaId = pizzaId,
        userId = userId,
        toppings = toppings,
        size = size,
        lastUpdated = lastUpdated
    )
}
fun FavPizza.toEntity(): FavPizzaEntity {
    return FavPizzaEntity(
        id = id,
        userId = userId,
        pizzaId = pizzaId,
        toppings = toppings,
        size = size,
        lastUpdated = lastUpdated
    )
}
