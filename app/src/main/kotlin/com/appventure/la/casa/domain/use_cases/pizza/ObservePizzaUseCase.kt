package com.appventure.la.casa.domain.use_cases.pizza

import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.repo.PizzaRepository
import kotlinx.coroutines.flow.Flow

class ObservePizzaUseCase(
    private val repository: PizzaRepository
) {
    operator fun invoke(
    ): Flow<List<Pizza>> =
        repository.observePizzas()
}