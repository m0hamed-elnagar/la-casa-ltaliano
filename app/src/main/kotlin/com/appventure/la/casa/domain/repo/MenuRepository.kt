package com.appventure.la.casa.domain.repo


import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.Topping
import com.appventure.la.casa.domain.models.ToppingId
import kotlinx.coroutines.flow.Flow

interface MenuRepository {

    /* All pizzas, alphabetically within category, highest priority first */
    fun observePizzas(category: PizzaCategory? = null): Flow<List<Pizza>>

    /* Single pizza (detail screen) */
    fun observePizza(id: String): Flow<Pizza?>

    /* All available toppings (for customisation screen) */
    fun observeToppings(): Flow<List<Topping>>

    /* Lookup toppings by ids (used by price calculator) */
    suspend fun getToppingsByIds(ids: List<ToppingId>): List<Topping>

    /* Background sync (pizzas + toppings) */
    suspend fun syncMenu()
}