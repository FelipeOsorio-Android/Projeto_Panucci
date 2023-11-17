package devandroid.felipe.restaurantepanucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import devandroid.felipe.restaurantepanucci.ui.components.BottomAppBarItem

@Composable
fun PanucciNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = highlightsListRoute
    ) {
        highlightsListScreen(navController)
        menuScreen(navController)
        drinksScreen(navController)
        productDetailsScreen(navController)
        checkoutScreen(navController)
    }

}

val bottomAppBarItems = listOf(
    BottomAppBarItem.HighLightsList,
    BottomAppBarItem.Menu,
    BottomAppBarItem.Drinks
)