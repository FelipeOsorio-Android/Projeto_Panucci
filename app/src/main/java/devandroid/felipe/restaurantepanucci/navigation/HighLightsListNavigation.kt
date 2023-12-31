package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.model.ProductModel
import devandroid.felipe.restaurantepanucci.ui.screens.HighlightsListScreen
import devandroid.felipe.restaurantepanucci.ui.viewmodels.HighlightsListViewModel

internal const val highlightsListRoute = "highlight"

fun NavGraphBuilder.highlightsListScreen(
    onNavigateToCheckout: () -> Unit,
    onNavigateToProductDetails: (ProductModel) -> Unit
) {
    composable(highlightsListRoute) {

        val viewModel = viewModel<HighlightsListViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        HighlightsListScreen(
            uiState = uiState,
            onProductClick = onNavigateToProductDetails,
            onOrderClick = onNavigateToCheckout
        )
    }
}

fun NavController.navigateToHighlightsList(navOptions: NavOptions? = null) {
    navigate(highlightsListRoute, navOptions)
}