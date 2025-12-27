package com.appventure.la.casa.domain.repo

import com.appventure.la.casa.domain.models.FavPizza
import kotlinx.coroutines.flow.Flow

interface FavPizzaRepository {

    /* ===== Write ===== */

    suspend fun addFavPizza(
        favPizza: FavPizza
    )
    suspend fun updateFavPizza(
        favPizza: FavPizza
    )
    suspend fun updateSize(
        favId: String,
        size: String
    )

    suspend fun removeFavPizza(favId: String)

    suspend fun clearFavPizzas()

    /* ===== Read ===== */

    fun getAllFavPizzas():  Flow<List<FavPizza>>

    fun getFavPizzasForPizza(
        pizzaId: String
    ): Flow<List<FavPizza>>

    suspend fun getFavPizzaById(
        favId: String
    ): FavPizza?
}
