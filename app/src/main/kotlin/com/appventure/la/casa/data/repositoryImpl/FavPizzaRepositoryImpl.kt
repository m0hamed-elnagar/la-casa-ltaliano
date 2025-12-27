package com.appventure.la.casa.data.repositoryImpl

import com.appventure.la.casa.data.mappers.toDomain
import com.appventure.la.casa.data.mappers.toEntity
import com.appventure.la.casa.data.room.favpizza.FavPizzaDao
import com.appventure.la.casa.domain.models.FavPizza
import com.appventure.la.casa.domain.repo.FavPizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavPizzaRepositoryImpl(
    private val favPizzaDao: FavPizzaDao
) : FavPizzaRepository {

    /* ===== Write ===== */

    override suspend fun addFavPizza(
        favPizza: FavPizza
    ) {
        favPizzaDao.insertFavPizza(
            favPizza.toEntity()
        )
    }

    override suspend fun updateFavPizza(
        favPizza: FavPizza
    ) {
        favPizzaDao.updateFavPizza(
            favPizza.toEntity()
        )
    }

    override suspend fun removeFavPizza(
        favId: String
    ) {
        favPizzaDao.deleteByFavId(favId)
    }

    override suspend fun clearFavPizzas() {
        favPizzaDao.clearAll()
    }

    /* ===== Read ===== */

    override fun getAllFavPizzas(): Flow<List<FavPizza>> {
        return favPizzaDao
            .getAllFavPizzas()
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override fun getFavPizzasForPizza(
        pizzaId: String
    ): Flow<List<FavPizza>> {
        return favPizzaDao
            .getFavPizzasForPizza(pizzaId)
            .map { list ->
                list.map { it.toDomain() }
            }
    }

    override suspend fun getFavPizzaById(
        favId: String
    ): FavPizza? {
        return favPizzaDao
            .getFavPizzaById(favId)
            ?.toDomain()
    }
}
