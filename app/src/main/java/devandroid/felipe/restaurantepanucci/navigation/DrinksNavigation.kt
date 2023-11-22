package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import devandroid.felipe.restaurantepanucci.model.ProductModel
import devandroid.felipe.restaurantepanucci.ui.screens.DrinksListScreen
import devandroid.felipe.restaurantepanucci.ui.viewmodels.DrinksListViewModel

internal const val drinksRoute = "drinks"

fun NavGraphBuilder.drinksScreen(onNavigateToProductDetails: (ProductModel) -> Unit) {
    composable(drinksRoute) {

        val viewModel = viewModel<DrinksListViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        DrinksListScreen(
            uiState = uiState,
            onProductClick = onNavigateToProductDetails
        )
    }
}

fun NavController.navigateToDrinks(navOptions: NavOptions? = null) {
    navigate(drinksRoute, navOptions)
}