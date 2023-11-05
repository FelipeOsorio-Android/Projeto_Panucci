package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.outlined.LocalBar
import devandroid.felipe.restaurantepanucci.ui.components.BottomAppBarItem

sealed class AppDestinations(val route: String) {

    object Highlight : AppDestinations("highlight")
    object Menu: AppDestinations("menu")
    object Details: AppDestinations("details")
    object Drinks: AppDestinations("drinks")
    object Checkout: AppDestinations("checkout")
}

val bottomAppBarItems = listOf(
    BottomAppBarItem(
        label = "Destaques",
        icon = Icons.Filled.AutoAwesome,
        destination = AppDestinations.Highlight
    ),
    BottomAppBarItem(
        label = "Menu",
        icon = Icons.Filled.RestaurantMenu,
        destination = AppDestinations.Menu
    ),
    BottomAppBarItem(
        label = "Bebidas",
        icon = Icons.Outlined.LocalBar,
        destination = AppDestinations.Drinks
    ),
)