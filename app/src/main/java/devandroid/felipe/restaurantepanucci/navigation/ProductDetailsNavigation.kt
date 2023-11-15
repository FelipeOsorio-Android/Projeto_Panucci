package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.ProductDetailsScreen

private const val productDetailsRoute = "details"
private const val productIdArguments = "productId"
fun NavGraphBuilder.productDetailsScreen(navController: NavHostController) {
    composable("$productDetailsRoute/{$productIdArguments}")
    { backStackEntry ->
        val id = backStackEntry.arguments?.getString(productIdArguments)
        sampleProducts.find {
            it.id == id
        }?.let {
            ProductDetailsScreen(
                product = sampleProducts.random(),
                onNavigateToCheckout = {
                    navController.navigateToCheckout()
                }
            )
        } ?: LaunchedEffect(Unit) {
            navController.navigateUp()
        }
    }
}

fun NavController.navigateToProductDetails(id: String) {
    navigate("$productDetailsRoute/$id")
}