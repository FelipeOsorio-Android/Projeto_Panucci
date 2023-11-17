package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.CheckoutScreen

internal const val checkoutRoute = "checkout"
fun NavGraphBuilder.checkoutScreen(navController: NavHostController) {
    composable(checkoutRoute) {
        CheckoutScreen(products = sampleProducts, onPopBackStack = {
            navController.navigateUp()
        })
    }
}

fun NavController.navigateToCheckout() {
    navigate(checkoutRoute)
}