package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.CheckoutScreen
fun NavGraphBuilder.checkoutScreen(navController: NavHostController) {
    composable(AppDestinations.Checkout.route) {
        CheckoutScreen(products = sampleProducts, onPopBackStack = {
            navController.navigateUp()
        })
    }
}