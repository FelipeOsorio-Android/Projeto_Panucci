package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.model.ProductModel
import devandroid.felipe.restaurantepanucci.ui.screens.MenuListScreen
import devandroid.felipe.restaurantepanucci.ui.viewmodels.MenuListViewModel

internal const val menuRoute = "menu"

fun NavGraphBuilder.menuScreen(
    onNavigateToProductDetails: (ProductModel) -> Unit
) {
    composable(menuRoute) {

        val viewModel = viewModel<MenuListViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        MenuListScreen(
            uiState = uiState,
            onProductClick = onNavigateToProductDetails
        )
    }
}

fun NavController.navigateToMenu(navOptions: NavOptions? = null) {
    navigate(menuRoute, navOptions)
}