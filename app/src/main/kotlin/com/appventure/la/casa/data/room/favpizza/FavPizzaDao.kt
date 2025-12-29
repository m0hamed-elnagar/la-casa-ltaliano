package com.appventure.la.casa.data.room.favpizza

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FavPizzaDao {

    /* ================= INSERT ================= */

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertFavPizza(favPizza: FavPizzaEntity)

    /* ================= DELETE ================= */


    @Query("DELETE FROM fav_pizza WHERE id = :favId")
    suspend fun deleteByFavId(favId: String)

    @Query("DELETE FROM fav_pizza")
    suspend fun clearAll()

    /* ================= UPDATE ================= */

    @Update
    suspend fun updateFavPizza(favPizza: FavPizzaEntity)


    /* ================= READ ================= */

    @Query("SELECT * FROM fav_pizza ORDER BY lastUpdated DESC")
    fun getAllFavPizzas(): Flow<List<FavPizzaEntity>>

    @Query("""
        SELECT * FROM fav_pizza 
        WHERE pizzaId = :pizzaId 
        ORDER BY lastUpdated DESC
    """)
    fun getFavPizzasForPizza(
        pizzaId: String
    ): Flow<List<FavPizzaEntity>>

    @Query("""
        SELECT * FROM fav_pizza 
        WHERE id = :favId
        LIMIT 1
    """)
    suspend fun getFavPizzaById(
        favId: String
    ): FavPizzaEntity?



}