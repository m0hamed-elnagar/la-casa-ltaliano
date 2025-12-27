package com.appventure.la.casa.domain.useCases.favPizza

import com.appventure.la.casa.domain.models.FavPizza
import com.appventure.la.casa.domain.repo.FavPizzaRepository
import kotlinx.coroutines.flow.Flow

class GetAllFavPizzasUseCase(
    private val repository: FavPizzaRepository
) {
    operator fun invoke(): Flow<List<FavPizza>> {
        return repository.getAllFavPizzas()
    }
}
