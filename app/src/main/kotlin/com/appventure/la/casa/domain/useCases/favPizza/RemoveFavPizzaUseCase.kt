package com.appventure.la.casa.domain.useCases.favPizza

import com.appventure.la.casa.domain.repo.FavPizzaRepository

class RemoveFavPizzaUseCase(
    private val repository: FavPizzaRepository
) {
    suspend operator fun invoke(
        favId: String
    ) {
        repository.removeFavPizza(favId)
    }
}
