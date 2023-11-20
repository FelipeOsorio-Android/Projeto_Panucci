package devandroid.felipe.restaurantepanucci.ui.uistate

import devandroid.felipe.restaurantepanucci.model.ProductModel

data class CheckoutUiState(
    val products: List<ProductModel> = emptyList()
)