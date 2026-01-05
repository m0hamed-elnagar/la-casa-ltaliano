package com.appventure.la.casa.data.local.room.converters

import androidx.room.TypeConverter
import java.time.Instant

class InstantConverter {

    @TypeConverter
    fun fromInstant(instant: Instant): Long =
        instant.toEpochMilli()

    @TypeConverter
    fun toInstant(epochMillis: Long): Instant =
        Instant.ofEpochMilli(epochMillis)
}
