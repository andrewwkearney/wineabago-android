package com.androsaces.wineabago.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androsaces.wineabago.data.model.Wine

@Database(entities = [Wine::class], version = 1, exportSchema = false)
abstract class WineDatabase: RoomDatabase() {
    abstract fun wineDao(): WineDao
}