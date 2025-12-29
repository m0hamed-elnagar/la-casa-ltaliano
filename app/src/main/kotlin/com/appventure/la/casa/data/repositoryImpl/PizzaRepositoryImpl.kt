package com.appventure.la.casa.data.repositoryImpl

import com.appventure.la.casa.data.mappers.toDomain
import com.appventure.la.casa.data.room.menu.PizzaDao
import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.Topping
import com.appventure.la.casa.domain.models.ToppingId
import com.appventure.la.casa.domain.repo.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PizzaRepositoryImpl(val pizzaDao: PizzaDao) : PizzaRepository {
    override fun observePizzas(category: PizzaCategory?): Flow<List<Pizza>> {
        return pizzaDao.observeAllPizzasWithSizes()
            .map { list -> list.map { it.toDomain() } }
    }

    override fun getPizzaDetails(id: String): Flow<Pizza?> {
        return pizzaDao.observePizzaWithSizes(id)
            .map { it?.toDomain() }
    }


    override fun observeToppings(): Flow<List<Topping>> {
        TODO("Not yet implemented")
    }

    override suspend fun getToppingsByIds(ids: List<ToppingId>): List<Topping> {
        TODO("Not yet implemented")
    }

    override suspend fun syncMenu() {
        TODO("Not yet implemented")
    }
}