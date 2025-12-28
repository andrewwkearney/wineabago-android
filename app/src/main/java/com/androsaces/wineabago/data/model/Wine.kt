package com.androsaces.wineabago.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wines")
data class Wine(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val region: String,
    val vintage: String,
    val boxNumber: String
)