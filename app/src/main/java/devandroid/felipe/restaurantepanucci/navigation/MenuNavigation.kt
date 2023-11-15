package devandroid.felipe.restaurantepanucci.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.sampledata.sampleProducts
import devandroid.felipe.restaurantepanucci.ui.screens.MenuListScreen

private const val menuRoute = "menu"

fun NavGraphBuilder.menuScreen(navController: NavHostController) {
    composable(menuRoute) {
        MenuListScreen(
            products = sampleProducts,
            onNavigateToDetails = { product ->
                navController.navigateToProductDetails(product.id)
            }
        )
    }
}

fun NavController.navigateToMenu() {
    navigate(menuRoute)
}