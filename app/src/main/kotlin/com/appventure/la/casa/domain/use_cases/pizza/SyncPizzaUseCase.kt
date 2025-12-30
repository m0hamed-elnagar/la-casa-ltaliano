package com.appventure.la.casa.domain.use_cases.pizza

import com.appventure.la.casa.domain.repo.PizzaRepository

class SyncPizzaUseCase(
    private val pizzaRepository: PizzaRepository

) {
    suspend operator fun invoke()= pizzaRepository.syncPizzas()
}

