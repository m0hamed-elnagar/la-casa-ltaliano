package com.appventure.la.casa.domain.useCases.favPizza

import com.appventure.la.casa.domain.repo.FavPizzaRepository

class UpdateFavPizzaSizeUseCase(
    private val repository: FavPizzaRepository
) {
    suspend operator fun invoke(
        favId: String,
        size: String
    ) {
        repository.updateSize(favId, size)
    }
}
