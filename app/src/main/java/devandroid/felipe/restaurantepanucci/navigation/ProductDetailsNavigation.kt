package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.ProductDetailsScreen
fun NavGraphBuilder.productDetailsScreen(navController: NavHostController) {
    composable("${AppDestinations.Details.route}/{productId}")
    { backStackEntry ->
        val id = backStackEntry.arguments?.getString("productId")
        sampleProducts.find {
            it.id == id
        }?.let {
            ProductDetailsScreen(
                product = sampleProducts.random(),
                onNavigateToCheckout = {
                    navController.navigate(AppDestinations.Checkout.route)
                }
            )
        } ?: LaunchedEffect(Unit) {
            navController.navigateUp()
        }
    }
}