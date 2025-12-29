package com.appventure.la.casa.data.mappers


import com.appventure.la.casa.data.room.menu.PizzaEntity
import com.appventure.la.casa.data.room.menu.PizzaSizeEntity
import com.appventure.la.casa.data.room.menu.PizzaWithSizes
import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.PizzaSize

/**
 * Maps a PizzaEntity + its size rows → domain Pizza.
 * If no size rows are supplied the map falls back to a sane default
 * (Medium as base and typical up-charges).
 */
fun PizzaEntity.toDomain(sizeRows: List<PizzaSizeEntity> = emptyList()): Pizza {
    val sizeMap = if (sizeRows.isEmpty()) {
//fallback
        emptyMap()
    } else {
        sizeRows.associate { row ->
            PizzaSize.valueOf(row.size) to row.extraPrice
        }
    }

    return Pizza(
        id = id,
        name = name,
        description = description,
        category = PizzaCategory.valueOf(category),
        basePrice = basePrice,
        imageUrl = imageUrl,
        sizes = sizeMap,
        defaultToppings = defaultToppings,
        availableToppings = availableToppings,
        priority = priority,
        isFeatured = isFeatured,
        isAvailable = isAvailable,
    )
}
fun PizzaWithSizes.toDomain(): Pizza =
    pizza.toDomain(sizes)


fun Pizza.toEntity(): PizzaEntity =
    PizzaEntity(
        id = id,
        name = name,
        description = description,
        category = category.name,
        basePrice = basePrice,
        imageUrl = imageUrl,
        defaultToppings = defaultToppings,
        availableToppings = availableToppings,
        priority = priority,
        isFeatured = isFeatured,
        isAvailable = isAvailable,
        lastUpdated = System.currentTimeMillis()
    )