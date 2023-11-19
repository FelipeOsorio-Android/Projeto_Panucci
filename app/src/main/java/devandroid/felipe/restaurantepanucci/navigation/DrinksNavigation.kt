package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.DrinksListScreen

internal const val drinksRoute = "drinks"

fun NavGraphBuilder.drinksScreen(navController: NavController) {
    composable(drinksRoute) {
        DrinksListScreen(
            products = sampleProducts,
            onNavigateToDetails = { product ->
                navController.navigateToProductDetails(product.id)
            }
        )
    }
}

fun NavController.navigateToDrinks(navOptions: NavOptions? = null) {
    navigate(drinksRoute, navOptions)
}