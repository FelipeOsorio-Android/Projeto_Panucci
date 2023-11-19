package devandroid.felipe.restaurantepanucci.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import androidx.navigation.navigation
import devandroid.felipe.restaurantepanucci.navigation.drinksRoute
import devandroid.felipe.restaurantepanucci.navigation.drinksScreen
import devandroid.felipe.restaurantepanucci.navigation.highlightsListRoute
import devandroid.felipe.restaurantepanucci.navigation.highlightsListScreen
import devandroid.felipe.restaurantepanucci.navigation.menuRoute
import devandroid.felipe.restaurantepanucci.navigation.menuScreen
import devandroid.felipe.restaurantepanucci.navigation.navigateToDrinks
import devandroid.felipe.restaurantepanucci.navigation.navigateToHighlightsList
import devandroid.felipe.restaurantepanucci.navigation.navigateToMenu
import devandroid.felipe.restaurantepanucci.ui.components.BottomAppBarItem

internal const val homeGraphRoute = "home"

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = highlightsListRoute, route = homeGraphRoute) {
        highlightsListScreen(navController)
        menuScreen(navController)
        drinksScreen(navController)
    }
}

fun NavController.navigateToHomeGraph(navOptions: NavOptions? = null) {
    navigate(homeGraphRoute)
}

fun NavController.navigateSingleTopWithPopUpTo(item: BottomAppBarItem) {

    val (route, navigation) = when(item) {
        BottomAppBarItem.Drinks -> Pair(
            drinksRoute,
            ::navigateToDrinks
        )
        BottomAppBarItem.HighLightsList -> Pair(
            highlightsListRoute,
            ::navigateToHighlightsList
        )
        BottomAppBarItem.Menu -> Pair(
            menuRoute,
            ::navigateToMenu
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }

    navigation(navOptions)
}