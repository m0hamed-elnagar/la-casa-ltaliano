package com.appventure.la.casa.domain.use_cases.favPizza

import com.appventure.la.casa.domain.models.FavPizza
import com.appventure.la.casa.domain.repo.FavPizzaRepository

class GetFavPizzaByIdUseCase(
    private val repository: FavPizzaRepository
) {
    suspend operator fun invoke(
        favId: String
    ): FavPizza? {
        return repository.getFavPizzaById(favId)
    }
}
