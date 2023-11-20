package devandroid.felipe.restaurantepanucci.dao

import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {
    val products = MutableStateFlow(sampleProducts).asStateFlow()

    fun findById(id: String) =
        products.value.firstOrNull {
            it.id == id
        }

}