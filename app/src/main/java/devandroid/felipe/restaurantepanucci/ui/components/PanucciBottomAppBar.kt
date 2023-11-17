package devandroid.felipe.restaurantepanucci.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import devandroid.felipe.restaurantepanucci.navigation.bottomAppBarItems
import devandroid.felipe.restaurantepanucci.navigation.drinksRoute
import devandroid.felipe.restaurantepanucci.navigation.highlightsListRoute
import devandroid.felipe.restaurantepanucci.navigation.menuRoute
import devandroid.felipe.restaurantepanucci.ui.theme.RestaurantePanucciTheme

open class BottomAppBarItem(
    val label: String,
    val icon: ImageVector,
    val destination: String
) {
    object HighLightsList : BottomAppBarItem(
    label = "Destaques",
    icon = Icons.Filled.AutoAwesome,
    destination = highlightsListRoute
    )
    object Menu : BottomAppBarItem(
    label = "Menu",
    icon = Icons.Filled.RestaurantMenu,
    destination = menuRoute
    )
    object Drinks : BottomAppBarItem(
    label = "Bebidas",
    icon = Icons.Outlined.LocalBar,
    destination = drinksRoute
    )
}

@Composable
fun PanucciBottomAppBar(
    item: BottomAppBarItem,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = emptyList(),
    onItemChange: (BottomAppBarItem) -> Unit = {}
) {
    NavigationBar(modifier) {
        items.forEach {
            val label = it.label
            val icon = it.icon
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) },
                selected = item.label == label,
                onClick = {
                    onItemChange(it)
                }
            )
        }
    }
}

@Preview
@Composable
fun PanucciBottomAppBarPreview() {
    RestaurantePanucciTheme {
        PanucciBottomAppBar(
            item = bottomAppBarItems.first(),
            items = bottomAppBarItems
        )
    }
}