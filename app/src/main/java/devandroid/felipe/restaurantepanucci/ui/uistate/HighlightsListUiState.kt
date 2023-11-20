package devandroid.felipe.restaurantepanucci.ui.uistate

import devandroid.felipe.restaurantepanucci.model.ProductModel

data class HighlightsListUiState(
    val products: List<ProductModel> = emptyList()
)