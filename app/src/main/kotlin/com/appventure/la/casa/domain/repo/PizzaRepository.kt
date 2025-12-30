package com.appventure.la.casa.domain.repo


import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.Topping
import com.appventure.la.casa.domain.models.ToppingId
import kotlinx.coroutines.flow.Flow

interface PizzaRepository {
    //read
    suspend fun downloadPizzas(): List<PizzaDto>
    suspend fun downloadPizzaSizes(): List<PizzaSizeDto>

    fun observePizzas(): Flow<List<Pizza>>

    /* Single pizza (detail screen) */
    fun getPizzaDetails(id: String): Flow<Pizza?>

    /* All available toppings (for customisation screen) */
    fun observeToppings(): Flow<List<Topping>>

    /* Lookup toppings by ids (used by price calculator) */
    suspend fun getToppingsByIds(ids: List<ToppingId>): List<Topping>
    //write
    suspend fun insertPizzas(pizzaList: List<Pizza>)
    suspend fun insertToppings(toppings: List<Topping>)
    /* Background sync (pizzas + toppings) */
    suspend fun syncPizzas()

    suspend fun syncToppings()
}