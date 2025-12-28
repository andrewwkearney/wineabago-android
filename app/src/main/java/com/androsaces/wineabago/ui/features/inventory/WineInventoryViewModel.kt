package com.androsaces.wineabago.ui.features.inventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androsaces.wineabago.data.model.Wine
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

// ui/features/inventory/WineInventoryViewModel.kt
class WineInventoryViewModel(
    // In a Hilt setup, the repository is injected here
    private val repository: WineRepository = WineRepository()
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    // Combining the repository data with the search query
    val uiState: StateFlow<WineInventoryUiState> = repository.getWines()
        .combine(_searchQuery) { wines, query ->
            val filtered = if (query.isEmpty()) {
                wines
            } else {
                wines.filter { it.name.contains(query, ignoreCase = true) }
            }
            WineInventoryUiState.Success(filtered)
        }
        .catch {  }
        .catch { e -> WineInventoryUiState.Error(e.message ?: "Unknown Error") }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = WineInventoryUiState.Loading
        )

    fun onSearchQueryChanged(newQuery: String) {
        _searchQuery.value = newQuery
    }
}