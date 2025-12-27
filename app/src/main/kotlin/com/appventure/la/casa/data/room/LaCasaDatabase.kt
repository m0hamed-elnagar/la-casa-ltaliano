package com.appventure.la.casa.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.appventure.la.casa.data.room.favpizza.FavPizzaDao
import com.appventure.la.casa.data.room.favpizza.FavPizzaEntity

@Database(entities = [FavPizzaEntity::class], version = 3,
    exportSchema = false   // Disable schema export
)
@TypeConverters(StringListConverter::class)
abstract class LaCasaDatabase : RoomDatabase() {
    abstract val favPizzaDao: FavPizzaDao
}