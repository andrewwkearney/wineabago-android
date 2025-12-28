package com.androsaces.wineabago.ui.features.inventory

import com.androsaces.wineabago.data.local.WineDao
import com.androsaces.wineabago.data.model.Wine
import kotlinx.coroutines.flow.Flow

class WineRepository(
    private val wineDao: WineDao
) {
    fun getWines(): Flow<List<Wine>> = wineDao.getAllWines()

    suspend fun deleteWine(wine: Wine) = wineDao.deleteWine(wine)
}
