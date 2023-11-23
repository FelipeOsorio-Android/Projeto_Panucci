package devandroid.felipe.restaurantepanucci.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import devandroid.felipe.restaurantepanucci.dao.ProductDao
import devandroid.felipe.restaurantepanucci.navigation.productIdArguments
import devandroid.felipe.restaurantepanucci.ui.uistate.ProductDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val dao: ProductDao = ProductDao(),
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow<String?>(productIdArguments, null)
                .filterNotNull()
                .collect {
                    findProductById(it)
                }
        }
    }


    fun findProductById(id: String) {
        dao.findById(id)?.let { product ->
            _uiState.update {
                it.copy(product = product)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ProductDetailsViewModel(ProductDao(), createSavedStateHandle())
            }
        }
    }

}