package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.DrinksListScreen

fun NavGraphBuilder.drinksScreen(navController: NavHostController) {
    composable(AppDestinations.Drinks.route) {
        DrinksListScreen(
            products = sampleProducts,
            onNavigateToDetails = { product ->
                navController.navigate(
                    "${AppDestinations.Details.route}/${product.id}"
                )
            }
        )
    }
}