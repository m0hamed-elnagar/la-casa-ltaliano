package com.appventure.la.casa.data.mappers


import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.room.menu.PizzaEntity
import com.appventure.la.casa.data.room.menu.PizzaSizeEntity
import com.appventure.la.casa.data.room.menu.PizzaWithSizes
import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.PizzaSize
import java.time.Instant

/**
 * Maps a PizzaEntity + its size rows → domain Pizza.
 * If no size rows are supplied the map falls back to a sane default
 * (Medium as base and typical up-charges).
 */
fun PizzaEntity.toDomain(sizeRows: List<PizzaSizeEntity>): Pizza =
    Pizza(
        id = id,
        name = name,
        description = description,
        rating = rating,
        offerTitle = offerTitle,
        haveBtn = haveBtn,
        offerPercentage = offerPercentage,
        category = PizzaCategory.valueOf(category),
        basePrice = basePrice,
        imageUrl = imageUrl,
        sizes = sizeRows.associate {
            PizzaSize.valueOf(it.size) to it.extraPrice
        },
        defaultToppings = defaultToppings,
        availableToppings = availableToppings,
        priority = priority,
        isFeatured = isFeatured,
        isAvailable = isAvailable
    )

fun PizzaWithSizes.toDomain(): Pizza =
    pizza.toDomain(sizes)


fun Pizza.toPizzaEntity(): PizzaEntity =
    PizzaEntity(
        id = id,
        name = name,
        description = description,
        rating= rating,
        offerTitle = offerTitle,
        haveBtn = haveBtn,
        offerPercentage = offerPercentage,
        category = category.name,
        basePrice = basePrice,
        imageUrl = imageUrl,
        defaultToppings = defaultToppings,
        availableToppings = availableToppings,
        priority = priority,
        isFeatured = isFeatured,
        isAvailable = isAvailable,
        lastUpdated = Instant.now()
    )

fun Pizza.toSizeEntities(): List<PizzaSizeEntity> =
    sizes.map {
        PizzaSizeEntity(
            pizzaId = id,
            size = it.key.name,
            extraPrice = it.value
        )
    }
fun PizzaDto.toPizzaEntity(): PizzaEntity =
    PizzaEntity(
        id = id,
        name = name,
        description = description,
        rating = rating,
        offerTitle = offerTitle,
        haveBtn = haveBtn,
        offerPercentage = offerPercentage,
        category = category,
        basePrice = basePrice.toInt(),
        imageUrl = imageUrl,
        defaultToppings = defaultToppings,
        availableToppings = availableToppings,
        priority = priority.toInt(),
        isFeatured = isFeatured,
        isAvailable = isAvailable,
         lastUpdated = lastUpdated?.toInstant() ?: Instant.EPOCH

    )
fun PizzaSizeDto.toPizzaSizeEntity(): PizzaSizeEntity =
    PizzaSizeEntity(
        pizzaId = pizzaId,
        size = size,
        extraPrice = extraPrice.toInt()
    )