package com.androsaces.wineabago.ui.features.inventory

import com.androsaces.wineabago.data.model.Wine
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.stream.Stream

class WineRepository {
    fun getWines(): Flow<List<Wine>> = flow {
        delay(1000)
        emit(listOf(
            // TODO put wines here
        ))
    }
}
