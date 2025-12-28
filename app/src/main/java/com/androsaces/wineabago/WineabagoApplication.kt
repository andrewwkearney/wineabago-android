package com.androsaces.wineabago

import android.app.Application
import androidx.room.Room
import com.androsaces.wineabago.data.local.WineDatabase
import com.androsaces.wineabago.ui.features.inventory.WineRepository

class WineabagoApplication : Application() {
    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            WineDatabase::class.java,
            "wineabago.db"
        ).build()
    }

    val wineRepository by lazy { WineRepository(database.wineDao()) }
}