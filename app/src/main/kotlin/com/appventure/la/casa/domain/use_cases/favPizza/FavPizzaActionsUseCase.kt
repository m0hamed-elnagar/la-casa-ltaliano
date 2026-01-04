package com.appventure.la.casa.domain.use_cases.favPizza

import com.appventure.la.casa.domain.models.FavPizza
import com.appventure.la.casa.domain.repo.FavPizzaRepository

class FavPizzaActionsUseCase(
    private val repository: FavPizzaRepository
) {
    suspend fun add(fav: FavPizza) =
        repository.addFavPizza(fav)

    suspend fun update(fav: FavPizza) =
        repository.updateFavPizza(fav)

    suspend fun remove(id: String) =
        repository.removeFavPizza(id)

    suspend fun clear() =
        repository.clearFavPizzas()
}
