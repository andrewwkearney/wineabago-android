package com.androsaces.wineabago.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.androsaces.wineabago.data.model.Wine
import kotlinx.coroutines.flow.Flow

@Dao
interface WineDao {
    @Query("""
        SELECT *
        FROM wines
    """)
    fun getAllWines(): Flow<List<Wine>>

    @Delete
    suspend fun deleteWine(wine: Wine)
}