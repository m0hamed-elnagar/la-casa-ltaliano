package com.appventure.la.casa.data.repositoryImpl

import com.appventure.la.casa.data.firebase.MenuRemoteDataSource
import com.appventure.la.casa.data.firebase.dto.PizzaDto
import com.appventure.la.casa.data.firebase.dto.PizzaSizeDto
import com.appventure.la.casa.data.mappers.*
import com.appventure.la.casa.data.room.menu.PizzaDao
import com.appventure.la.casa.data.room.menu.PizzaSizeEntity
import com.appventure.la.casa.domain.models.Pizza
import com.appventure.la.casa.domain.models.PizzaCategory
import com.appventure.la.casa.domain.models.Topping
import com.appventure.la.casa.domain.models.ToppingId
import com.appventure.la.casa.domain.repo.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PizzaRepositoryImpl(
    val pizzaDao: PizzaDao,
    val menuRemoteDataSource: MenuRemoteDataSource
) : PizzaRepository {

    override suspend fun downloadPizzas(): List<PizzaDto> {
        return menuRemoteDataSource.getPizzaMenu()
    }

    override suspend fun downloadPizzaSizes(): List<PizzaSizeDto> {
        return menuRemoteDataSource.getPizzaSizes()
    }

    override fun observePizzas(): Flow<List<Pizza>> {
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

    override suspend fun insertPizzas(pizzaList: List<Pizza>) {
        val pizzaLisEntity = pizzaList.map { it.toPizzaEntity() }
        val sizeList: List<PizzaSizeEntity> = pizzaList.map { it.toSizeEntities() }.flatten()
        pizzaDao.insertPizzasAndSizes(pizzaLisEntity, sizeList)

    }

    override suspend fun insertToppings(toppings: List<Topping>) {

    }

    override suspend fun syncToppings() {
        TODO("Not yet implemented")
    }

    override suspend fun syncPizzas() {
        val pizzasDto = downloadPizzas()
        val pizzaSizesDto = downloadPizzaSizes()
        pizzaDao.upsertPizzaList(pizzasDto.map { it.toPizzaEntity() })
        pizzaDao.upsertPizzaSizes(pizzaSizesDto.map { it.toPizzaSizeEntity() })
    }
}