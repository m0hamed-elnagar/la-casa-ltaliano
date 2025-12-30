package com.appventure.la.casa.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appventure.la.casa.data.room.converters.InstantConverter
import com.appventure.la.casa.data.room.converters.StringListConverter
import com.appventure.la.casa.data.room.favpizza.FavPizzaDao
import com.appventure.la.casa.data.room.favpizza.FavPizzaEntity
import com.appventure.la.casa.data.room.menu.*

@Database(entities = [FavPizzaEntity::class, PizzaEntity::class, PizzaSizeEntity::class, ToppingEntity::class], version = 1,
    exportSchema = false   // Disable schema export
)
@TypeConverters(StringListConverter::class, InstantConverter::class)
abstract class LaCasaDatabase : RoomDatabase() {
    abstract val favPizzaDao: FavPizzaDao
    abstract val pizzaDao: PizzaDao

}