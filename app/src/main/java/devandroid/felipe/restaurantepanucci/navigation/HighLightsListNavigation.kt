package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.HighlightsListScreen

fun NavGraphBuilder.highlightsListScreen(navController: NavHostController) {
    composable(AppDestinations.Highlight.route) {
        HighlightsListScreen(
            products = sampleProducts,
            onNavigateToDetails = { product ->
                navController.navigate(
                    "${AppDestinations.Details.route}/${product.id}"
                )
            },
            onNavigateToCheckout = {
                navController.navigate(AppDestinations.Checkout.route)
            }
        )
    }
}