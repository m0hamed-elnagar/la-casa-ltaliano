package com.appventure.la.casa.data.room.menu

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {
    @Transaction
    @Query("SELECT * FROM pizzas WHERE id = :id")
    fun observePizzaWithSizes(id: String): Flow<PizzaWithSizes?>

    @Transaction
    @Query("SELECT * FROM pizzas ORDER BY priority DESC")
    fun observeAllPizzasWithSizes(): Flow<List<PizzaWithSizes>>

    @Upsert
    suspend fun upsertPizzaList(pizzas: List<PizzaEntity>)

    @Upsert
    suspend fun upsertPizzaSizes(sizes: List<PizzaSizeEntity>)

    @Upsert
    suspend fun upsertToppingList(toppings: List<ToppingEntity>)

    @Transaction
    suspend fun insertPizzasAndSizes(
        pizzas: List<PizzaEntity>,
        sizes: List<PizzaSizeEntity>
    ) {
        upsertPizzaList(pizzas)
        insertSizes(sizes)
    }


    @Transaction
    suspend fun replaceAllPizzas(pizzas: List<PizzaEntity>) {
        deleteAll()
        upsertPizzaList(pizzas)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizza(pizza: PizzaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSizes(sizes: List<PizzaSizeEntity>)

    @Transaction
    suspend fun insertPizzaWithSizes(
        pizza: PizzaEntity,
        sizes: List<PizzaSizeEntity>
    ) {
        insertPizza(pizza)

        val sizesWithId = sizes.map {
            it.copy(pizzaId = pizza.id)
        }

        insertSizes(sizesWithId)
    }

    @Query("DELETE FROM pizzas")
    suspend fun deleteAll()

}
