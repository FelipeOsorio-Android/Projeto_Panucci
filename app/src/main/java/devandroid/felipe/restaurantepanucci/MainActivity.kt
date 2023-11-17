package devandroid.felipe.restaurantepanucci

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PointOfSale
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import devandroid.felipe.restaurantepanucci.navigation.PanucciNavHost
import devandroid.felipe.restaurantepanucci.navigation.drinksRoute
import devandroid.felipe.restaurantepanucci.navigation.highlightsListRoute
import devandroid.felipe.restaurantepanucci.navigation.menuRoute
import devandroid.felipe.restaurantepanucci.navigation.navigateToCheckout
import devandroid.felipe.restaurantepanucci.navigation.navigateToDrinks
import devandroid.felipe.restaurantepanucci.navigation.navigateToHighlightsList
import devandroid.felipe.restaurantepanucci.navigation.navigateToMenu
import devandroid.felipe.restaurantepanucci.ui.components.BottomAppBarItem
import devandroid.felipe.restaurantepanucci.ui.components.PanucciBottomAppBar
import devandroid.felipe.restaurantepanucci.ui.components.bottomAppBarItems
import devandroid.felipe.restaurantepanucci.ui.theme.RestaurantePanucciTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination

            RestaurantePanucciTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val currentRoute = currentDestination?.route
                    val selectedItem by remember(currentDestination) {

                        val item = when(currentRoute) {
                            highlightsListRoute -> BottomAppBarItem.HighLightsList

                            menuRoute -> BottomAppBarItem.Menu

                            drinksRoute -> BottomAppBarItem.Drinks

                            else -> BottomAppBarItem.HighLightsList
                        }
                        mutableStateOf(item)
                    }

                    val containsInBottomAppBarItems = when(currentRoute) {
                        highlightsListRoute, menuRoute, drinksRoute -> true
                        else -> false
                    }

                    val isShowFab = when(currentRoute) {
                        menuRoute, drinksRoute -> true
                        else -> false
                    }

                    PanucciApp(
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = { item ->

                            val (route, navigation) = when(item) {
                                BottomAppBarItem.Drinks -> Pair(
                                    drinksRoute,
                                    navController::navigateToDrinks
                                )
                                BottomAppBarItem.HighLightsList -> Pair(
                                    highlightsListRoute,
                                    navController::navigateToHighlightsList
                                )
                                BottomAppBarItem.Menu -> Pair(
                                    menuRoute,
                                    navController::navigateToMenu
                                )
                            }

                            val navOptions = navOptions {
                                launchSingleTop = true
                                popUpTo(route)
                            }

                            navigation(navOptions)

                        },
                        onFabClick = {
                            navController.navigateToCheckout()
                        },
                        isShowTopAppBar = containsInBottomAppBarItems,
                        isShowBottomBar = containsInBottomAppBarItems,
                        isShowFab = isShowFab
                    ) {
                        PanucciNavHost(navController = navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PanucciApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    onFabClick: () -> Unit = {},
    isShowTopAppBar: Boolean = false,
    isShowBottomBar: Boolean = false,
    isShowFab: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (isShowTopAppBar) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Ristorante Panucci")
                    },
                )
            }
        },
        bottomBar = {
            if(isShowBottomBar) {
                PanucciBottomAppBar(
                    item = bottomAppBarItemSelected,
                    items = bottomAppBarItems,
                    onItemChange = onBottomAppBarItemSelectedChange,
                )
            }
        },
        floatingActionButton = {
            if (isShowFab) {
                FloatingActionButton(
                    onClick = onFabClick
                ) {
                    Icon(
                        Icons.Filled.PointOfSale,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun PanucciAppPreview() {
    RestaurantePanucciTheme {
        Surface {
            PanucciApp {}
        }
    }
}