package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.ui.screens.ProductDetailsScreen
import devandroid.felipe.restaurantepanucci.ui.viewmodels.ProductDetailsViewModel

internal const val productDetailsRoute = "details"
internal const val productIdArguments = "productId"
fun NavGraphBuilder.productDetailsScreen(
    onNavigateToCheckout: () -> Unit,
    onPopBackStack: () -> Unit
) {

    composable("$productDetailsRoute/{$productIdArguments}")
    { backStackEntry ->

        val id = backStackEntry.arguments?.getString(productIdArguments)
        val viewModel = viewModel<ProductDetailsViewModel>(factory = ProductDetailsViewModel.Factory)
        val uiState by viewModel.uiState.collectAsState()

        id?.let {
            ProductDetailsScreen(
                uiState = uiState,
                onOrderClick = onNavigateToCheckout,
            )
        } ?: LaunchedEffect(Unit) {
            onPopBackStack()
        }
    }
}

fun NavController.navigateToProductDetails(id: String) {
    navigate("$productDetailsRoute/$id")
}