package com.appventure.la.casa.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appventure.la.casa.data.local.room.converters.InstantConverter
import com.appventure.la.casa.data.local.room.converters.StringListConverter
import com.appventure.la.casa.data.local.room.favpizza.FavPizzaDao
import com.appventure.la.casa.data.local.room.favpizza.FavPizzaEntity
import com.appventure.la.casa.data.local.room.menu.PizzaDao
import com.appventure.la.casa.data.local.room.menu.PizzaEntity
import com.appventure.la.casa.data.local.room.menu.PizzaSizeEntity
import com.appventure.la.casa.data.local.room.menu.ToppingEntity

@Database(entities = [FavPizzaEntity::class, PizzaEntity::class, PizzaSizeEntity::class, ToppingEntity::class], version = 1,
    exportSchema = false   // Disable schema export
)
@TypeConverters(StringListConverter::class, InstantConverter::class)
abstract class LaCasaDatabase : RoomDatabase() {
    abstract val favPizzaDao: FavPizzaDao
    abstract val pizzaDao: PizzaDao

}