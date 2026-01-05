package com.appventure.la.casa.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appventure.la.casa.ui.models_ui.Banner
import com.appventure.la.casa.ui.models_ui.BannerList
import com.appventure.la.casa.ui.models_ui.CategoriesList
import com.appventure.la.casa.ui.models_ui.Category
import com.appventure.la.casa.ui.models_ui.Popular
import com.appventure.la.casa.ui.models_ui.PopularList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// Define the UI State data class
data class HomeUiState(
    val banners: List<Banner> = emptyList(),
    val categories: List<Category> = emptyList(),
    val popularItems: List<Popular> = emptyList(),
    val isLoading: Boolean = true
)

// Create the ViewModel
class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        // Fetch data when the ViewModel is created
        fetchHomeScreenData()
    }

    private fun fetchHomeScreenData() {
        viewModelScope.launch {

            // Update the state
            _uiState.update {
                it.copy(
                    banners = BannerList,
                    categories = CategoriesList,
                    popularItems = PopularList,
                    isLoading = false
                )
            }
        }
    }
}
