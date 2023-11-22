package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import devandroid.felipe.restaurantepanucci.navigation.graph.homeGraph
import devandroid.felipe.restaurantepanucci.navigation.graph.homeGraphRoute

@Composable
fun PanucciNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = homeGraphRoute
    ) {
        homeGraph(
            onNavigateToCheckout = {
                navController.navigateToCheckout()
            },
            onNavigateToProductDetails = { product ->
                navController.navigateToProductDetails(product.id)
            },
        )
        productDetailsScreen(
            onNavigateToCheckout = {
                navController.navigateToCheckout()
            },
            onPopBackStack = {
                navController.navigateUp()
            },
        )
        checkoutScreen(
            onPopBackStack = {
                navController.navigateUp()
                navController.currentBackStackEntry
                    ?.savedStateHandle
                    ?.set("order_done", " ✅ Produto adiquirido com sucesso")
            },
        )
    }

}