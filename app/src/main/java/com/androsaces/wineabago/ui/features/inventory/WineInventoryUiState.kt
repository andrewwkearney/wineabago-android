package com.androsaces.wineabago.ui.features.inventory

import com.androsaces.wineabago.data.model.Wine

sealed interface WineInventoryUiState {
    object Loading : WineInventoryUiState
    data class Success(val wine: List<Wine>) : WineInventoryUiState
    data class Error(val message: String) : WineInventoryUiState
}