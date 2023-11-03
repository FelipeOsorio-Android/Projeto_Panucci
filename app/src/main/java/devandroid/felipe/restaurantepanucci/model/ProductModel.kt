package devandroid.felipe.restaurantepanucci.model

import java.math.BigDecimal

class ProductModel(
    val name: String,
    val price: BigDecimal,
    val description: String,
    val image: String? = null
)