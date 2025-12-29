package com.appventure.la.casa.data.room.menu

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {
    @Transaction
    @Query("SELECT * FROM pizzas WHERE id = :id")
    fun observePizzaWithSizes(id: String): Flow<PizzaWithSizes?>

    @Transaction
    @Query("SELECT * FROM pizzas ORDER BY priority DESC")
    fun observeAllPizzasWithSizes(): Flow<List<PizzaWithSizes>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pizzas: List<PizzaEntity>)

    @Query("DELETE FROM pizzas")
    suspend fun deleteAll()

    @Transaction
    suspend fun replaceAllPizzas(pizzas: List<PizzaEntity>) {
        deleteAll()
        insertAll(pizzas)
    }
}
