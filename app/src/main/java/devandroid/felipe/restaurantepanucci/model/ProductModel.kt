package devandroid.felipe.restaurantepanucci.model

import java.math.BigDecimal
import java.util.UUID

data class ProductModel(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: BigDecimal,
    val description: String,
    val image: String? = null
)