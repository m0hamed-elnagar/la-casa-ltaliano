package com.appventure.la.casa.domain.useCases.favPizza

import com.appventure.la.casa.domain.repo.FavPizzaRepository

class ClearFavPizzasUseCase(
    private val repository: FavPizzaRepository
) {
    suspend operator fun invoke() {
        repository.clearFavPizzas()
    }
}
