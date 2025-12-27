package com.appventure.la.casa.domain.useCases.favPizza

import com.appventure.la.casa.domain.models.FavPizza
import com.appventure.la.casa.domain.repo.FavPizzaRepository

class UpdateFavPizzaUseCase(
    private val repository: FavPizzaRepository
) {
    suspend operator fun invoke(
        favPizza: FavPizza
    ) {
        repository.updateFavPizza(favPizza)
    }
}