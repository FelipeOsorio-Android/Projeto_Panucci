package devandroid.felipe.restaurantepanucci.ui.viewmodels

import androidx.lifecycle.ViewModel
import devandroid.felipe.restaurantepanucci.dao.ProductDao
import devandroid.felipe.restaurantepanucci.ui.uistate.ProductDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductDetailsViewModel(
    private val dao: ProductDao = ProductDao()
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailsUiState())
    val uiState = _uiState.asStateFlow()


    fun findProductById(id: String) {
        dao.findById(id)?.let { product ->
            _uiState.update {
                it.copy(product = product)
            }
        }
    }

}